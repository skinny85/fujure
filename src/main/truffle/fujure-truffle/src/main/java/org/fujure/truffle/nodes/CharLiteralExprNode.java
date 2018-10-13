package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class CharLiteralExprNode extends ExprNode {
    private final char value;

    public CharLiteralExprNode(char value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return (int) value;
    }

    @Override
    public int executeInt(VirtualFrame virtualFrame) {
        return value;
    }
}
