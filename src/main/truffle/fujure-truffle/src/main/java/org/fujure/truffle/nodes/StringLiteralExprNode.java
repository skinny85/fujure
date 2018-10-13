package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class StringLiteralExprNode extends ExprNode {
    private final String value;

    public StringLiteralExprNode(String value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public String executeString(VirtualFrame virtualFrame) {
        return value;
    }
}
