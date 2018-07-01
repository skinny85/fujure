package org.fujure.truffle;

import com.oracle.truffle.api.CallTarget
import com.oracle.truffle.api.Scope
import com.oracle.truffle.api.Truffle
import com.oracle.truffle.api.TruffleLanguage
import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.parse.BnfcParser
import org.fujure.fbc.read.OpenedFile
import org.fujure.truffle.nodes.ModuleNode
import org.funktionale.either.Disjunction

class FujureTruffleLanguage : TruffleLanguage<FujureTruffleContext>() {
    override fun createContext(env: Env): FujureTruffleContext {
        return FujureTruffleContext();
    }

    override fun isObjectOfLanguage(obj: Any): Boolean {
        return false;
    }

    override fun parse(request: ParsingRequest): CallTarget {
        val requestPath = request.source.path ?: request.source.name
        val path = if (requestPath.endsWith(".fjr")) requestPath else "$requestPath.fjr"

        val parsingResult = BnfcParser.parse(OpenedFile(
                InputFile(path), request.source.reader))

        return when (parsingResult) {
            is Disjunction.Left -> throw FujureTruffleParsingException(request.source, parsingResult.value)
            is Disjunction.Right -> Truffle.getRuntime().createCallTarget(ModuleNode(this,
                    parsingResult.value.ast.packageName,
                    parsingResult.value.inputFile.moduleName,
                    parsingResult.value.ast.defs.map { def -> Ast2TruffleNodes.translate(def, this) }))
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
