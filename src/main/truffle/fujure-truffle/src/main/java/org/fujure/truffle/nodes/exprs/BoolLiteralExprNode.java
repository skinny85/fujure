package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class BoolLiteralExprNode extends ExprNode {
    private final boolean value;

    public BoolLiteralExprNode(boolean value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public boolean executeBoolean(VirtualFrame frame) {
        return value;
    }
}
