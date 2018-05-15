package org.fujure.truffle;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;

@TruffleLanguage.Registration(
        id = FujureTruffleLanguage.LANG_ID,
        name = "FUJURE",
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
    protected CallTarget parse(ParsingRequest request) {
        return Truffle.getRuntime().createCallTarget(new FujureRootNode(this));
    }
}
