package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleBindings;

public final class LocalReferenceExprNode extends ExprNode {
    private final String reference;
    private final FujureTruffleBindings.ModuleBindings bindings;

    public LocalReferenceExprNode(String reference, FujureTruffleBindings.ModuleBindings bindings) {
        this.reference = reference;
        this.bindings = bindings;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return bindings.find(reference);
    }
}
