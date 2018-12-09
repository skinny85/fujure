package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.ast.ValueReference;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

public final class ReferenceExprNode extends ExprNode {
    private final ValueReference reference;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(ValueReference reference, FujureTruffleLanguage fujureTruffleLanguage) {
        this.reference = reference;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return contextReference.get().findInCurrentModule(reference);
    }
}
