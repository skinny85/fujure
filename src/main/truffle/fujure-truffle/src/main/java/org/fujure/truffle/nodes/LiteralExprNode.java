package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class LiteralExprNode extends ExprNode {
    private final Object value;

    protected LiteralExprNode(Object value) {
        this.value = value;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return value;
    }
}
