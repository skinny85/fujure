package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

public final class ReferenceExprNode extends ExprNode {
    private final String ref;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(String ref, FujureTruffleLanguage fujureTruffleLanguage) {
        this.ref = ref;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return contextReference.get().lookup(ref);
    }
}
