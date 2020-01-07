package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.ast.Module;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

public final class ReferenceExprNode extends ExprNode {
    private final Module targetModule;
    private final String reference;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(Module targetModule, String reference, FujureTruffleLanguage fujureTruffleLanguage) {
        this.targetModule = targetModule;
        this.reference = reference;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return contextReference.get().find(targetModule, reference);
    }
}
