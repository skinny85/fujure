package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class CharLiteralExprNode extends ExprNode {
    private final char value;

    public CharLiteralExprNode(char value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public char executeCharacter(VirtualFrame frame) {
        return value;
    }
}
