package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class FuncArgumentReferenceExprNode extends ExprNode {
    private final int index;

    public FuncArgumentReferenceExprNode(int index) {
        this.index = index;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return frame.getArguments()[index];
    }
}
