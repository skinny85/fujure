package org.fujure.truffle

import com.oracle.truffle.api.CallTarget
import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.Truffle
import com.oracle.truffle.api.TruffleLanguage
import org.fujure.fbc.analyze.SemanticAnalysisResult
import org.fujure.fbc.analyze.SimpleSemanticAnalyzer
import org.fujure.fbc.analyze.SymbolTable
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.read.OpenedFile
import org.fujure.truffle.nodes.RootModuleNode
import org.funktionale.either.Disjunction

class FujureTruffleLanguage : TruffleLanguage<FujureTruffleContext>() {
    private var symbolTable: SymbolTable? = null

    override fun createContext(env: Env): FujureTruffleContext {
        return FujureTruffleContext()
    }

    override fun isObjectOfLanguage(obj: Any): Boolean {
        return false
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
                        symbolTable = analysisResults.symbolTable
                        Truffle.getRuntime().createCallTarget(RootModuleNode(
                            this,
                            Aast2TruffleNodes(analysisResults.aasts.first(), this).translate()
                        ))
                    }
                }
            }
        }
    }

    override fun findTopScopes(context: FujureTruffleContext): Iterable<Scope> {
        return context.findTopScopes()
    }

    companion object {
        val LANG_ID = "fujure"
        val MIME_TYPE = "application/x-fujure"
    }
}
