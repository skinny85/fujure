package org.fujure.truffle;

import com.oracle.truffle.api.CallTarget
import com.oracle.truffle.api.Truffle
import com.oracle.truffle.api.TruffleLanguage
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureLexer
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureParser
import org.fujure.truffle.parse.FujureTruffleAntlrErrorListener
import java.lang.String.format
import java.util.stream.Collectors

class FujureTruffleLanguage : TruffleLanguage<FujureTruffleContext>() {
    override fun createContext(env: Env): FujureTruffleContext {
        return FujureTruffleContext();
    }

    override fun isObjectOfLanguage(obj: Any): Boolean {
        return false;
    }

    override fun parse(request: ParsingRequest): CallTarget {
        val lexer = FujureLexer(ANTLRInputStream(request.getSource().getInputStream()));
        val parser = FujureParser(CommonTokenStream(lexer));
        parser.removeErrorListeners();
        val errorListener = FujureTruffleAntlrErrorListener();
        parser.addErrorListener(errorListener);

        val fileContentsContext = parser.fileContents();
        val fileContents = fileContentsContext.result;

        if (errorListener.hasErrors()) {
            throw RuntimeException(format("Could not parse '%s':\n%s",
                    request.getSource().getName(),
                    errorListener.errors().stream()
                            .map { s -> format("\t(%d, %d): %s", s.line, s.column, s.msg) }
                            .collect(Collectors.joining("\n"))));
        }

        return Truffle.getRuntime().createCallTarget(FujureRootNode(this, fileContents));
    }

    companion object {
        val LANG_ID = "fujure"
        val MIME_TYPE = "application/x-fujure"
    }
}
