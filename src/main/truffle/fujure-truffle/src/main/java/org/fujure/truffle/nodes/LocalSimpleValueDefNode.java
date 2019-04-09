package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;

public final class LocalSimpleValueDefNode extends LocalValueDefNode {
    private final FrameSlot frameSlot;

    @Child
    private ExprNode initializer;

    public LocalSimpleValueDefNode(FrameSlot frameSlot, ExprNode initializer) {
        this.frameSlot = frameSlot;
        this.initializer = initializer;
    }

    @Override
    public void register(VirtualFrame frame) {
        Object result = this.initializer.executeGeneric(frame);
//        frameSlot.setKind(FrameSlotKind.Object);
        frame.setObject(frameSlot, result);
    }

    @Override
    public void deregister(VirtualFrame frame) {
        frame.setObject(frameSlot, null);
    }
}
