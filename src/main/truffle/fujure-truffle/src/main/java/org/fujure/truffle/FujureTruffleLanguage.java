package org.fujure.truffle;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureLexer;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureParser;
import org.fujure.truffle.parse.FujureTruffleAntlrErrorListener;

import java.util.stream.Collectors;

import static java.lang.String.format;

@TruffleLanguage.Registration(
        id = FujureTruffleLanguage.LANG_ID,
        name = "Fujure",
        version = "0.0.1",
        mimeType = FujureTruffleLanguage.MIME_TYPE
)
@ProvidedTags({
        StandardTags.CallTag.class,
        StandardTags.StatementTag.class,
        StandardTags.RootTag.class,
        StandardTags.ExpressionTag.class,
        DebuggerTags.AlwaysHalt.class
})
public class FujureTruffleLanguage extends TruffleLanguage<FujureTruffleContext> {
    public static final String LANG_ID = "fujure";
    public static final String MIME_TYPE = "application/x-fujure";

    public FujureTruffleLanguage() {
        super();
    }

    @Override
    protected FujureTruffleContext createContext(Env env) {
        return new FujureTruffleContext();
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        FujureLexer lexer = new FujureLexer(new ANTLRInputStream(request.getSource().getInputStream()));
        FujureParser parser = new FujureParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        FujureTruffleAntlrErrorListener errorListener = new FujureTruffleAntlrErrorListener();
        parser.addErrorListener(errorListener);

        FujureParser.FileContentsContext fileContentsContext = parser.fileContents();
        FileContents fileContents = fileContentsContext.result;

        if (errorListener.hasErrors()) {
            throw new RuntimeException(format("Could not parse '%s':\n%s",
                    request.getSource().getName(),
                    errorListener.errors().stream()
                            .map(s -> format("\t(%d, %d): %s", s.line, s.column, s.msg))
                            .collect(Collectors.joining("\n"))));
        }

        return Truffle.getRuntime().createCallTarget(new FujureRootNode(this, fileContents));
    }
}
