package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;

public final class LocalReferenceExprNode extends ExprNode {
    private final FrameSlot frameSlot;

    public LocalReferenceExprNode(FrameSlot frameSlot) {
        this.frameSlot = frameSlot;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return frame.getValue(frameSlot);
    }
}
