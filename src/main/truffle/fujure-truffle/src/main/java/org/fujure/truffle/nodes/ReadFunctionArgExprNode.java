package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class ReadFunctionArgExprNode extends ExprNode {
    private final int index;

    public ReadFunctionArgExprNode(int index) {
        this.index = index;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return frame.getArguments()[index];
    }
}
