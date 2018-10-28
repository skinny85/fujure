package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class IntLiteralExprNode extends ExprNode {
    private final int value;

    public IntLiteralExprNode(int value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInteger(VirtualFrame frame) {
        return value;
    }
}
