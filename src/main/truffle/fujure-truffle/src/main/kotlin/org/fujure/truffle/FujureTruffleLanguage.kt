package org.fujure.truffle

import com.oracle.truffle.api.CallTarget
import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.Truffle
import com.oracle.truffle.api.TruffleLanguage
import com.oracle.truffle.api.dsl.NodeFactory
import com.oracle.truffle.api.frame.FrameDescriptor
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.analyze.SimpleSemanticAnalyzer
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.Module
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.read.OpenedFile
import org.fujure.truffle.nodes.RootFunctionNode
import org.fujure.truffle.nodes.RootModuleNode
import org.fujure.truffle.nodes.exprs.ExprNode
import org.fujure.truffle.nodes.exprs.FuncArgumentReferenceExprNode
import org.fujure.truffle.nodes.exprs.builtins.Int.IntAbsBuiltInFunction
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr
import org.fujure.truffle.nodes.exprs.builtins.Int.IntMaxBuiltInFunction
import org.fujure.truffle.nodes.exprs.builtins.Int.IntMinBuiltInFunction
import org.fujure.truffle.runtime.FujureFunctionObject
import org.funktionale.either.Disjunction

class FujureTruffleLanguage : TruffleLanguage<FujureTruffleContext>() {
    private var symbolTable: SymbolTable? = null

    override fun createContext(env: Env): FujureTruffleContext {
        val context = FujureTruffleContext()

        /* *** add the built-in modules, with values *** */

        // fujure.Int
        val intModule = Module("fujure", "Int")
        context.resetModule(intModule);
        context.registerValue(intModule, "minInt", Integer.MIN_VALUE)
        context.registerValue(intModule, "maxInt", Integer.MAX_VALUE)
        registerBuiltInFunction(context, intModule, "abs", IntAbsBuiltInFunction.getFactory())
        registerBuiltInFunction(context, intModule, "min", IntMinBuiltInFunction.getFactory())
        registerBuiltInFunction(context, intModule, "max", IntMaxBuiltInFunction.getFactory())

        return context
    }

    override fun parse(request: ParsingRequest): CallTarget {
        val requestPath = request.source.path ?: request.source.name
        val path = if (requestPath.endsWith(".fjr")) requestPath else "$requestPath.fjr"

        val parsingResult = BnfcParser.parse(OpenedFile(
                InputFile(path), request.source.reader))

        return when (parsingResult) {
            is Disjunction.Left -> {
                throw FujureTruffleParsingException(request.source, parsingResult.value)
            }
            is Disjunction.Right -> {
                val parsedFile = parsingResult.value
                val analysisResults = SimpleSemanticAnalyzer.analyze(setOf(parsedFile), symbolTable ?: SymbolTable())
                when (analysisResults) {
                    is SemanticAnalysisResult.Failure -> {
                        throw FujureTruffleSemanticException(analysisResults.issues.first())
                    }
                    is SemanticAnalysisResult.Success -> {
                        this.symbolTable = analysisResults.symbolTable
                        val frameDescriptor = FrameDescriptor()
                        Truffle.getRuntime().createCallTarget(RootModuleNode(
                            this,
                            frameDescriptor,
                            Aast2TruffleNodes(this, frameDescriptor).translate(analysisResults.aasts.first())
                        ))
                    }
                }
            }
        }
    }

    override fun findTopScopes(context: FujureTruffleContext): Iterable<Scope> {
        return context.findTopScopes()
    }

    override fun isObjectOfLanguage(obj: Any): Boolean {
        return false
    }

    private fun registerBuiltInFunction(context: FujureTruffleContext, module: Module, name: String,
            functionBodyFactory: NodeFactory<out BuiltInFunctionBodyExpr>) {
        val argumentCount = functionBodyFactory.executionSignature.size
        val argumentNodes = arrayOfNulls<ExprNode>(argumentCount)
        for (i in 0 until argumentCount) {
            argumentNodes[i] = FuncArgumentReferenceExprNode(i)
        }

        context.registerValue(module, name,
                FujureFunctionObject(Truffle.getRuntime().createCallTarget(
                        RootFunctionNode(this, FrameDescriptor(), functionBodyFactory.createNode(argumentNodes)))))
    }

    companion object {
        val LANG_ID = "fujure"
        val MIME_TYPE = "application/x-fujure"
    }
}
