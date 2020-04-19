package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.ImportStatic;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.VirtualFrame;

@NodeField(name = "frameSlot", type = FrameSlot.class)
@ImportStatic(FrameSlotKind.class) // for the 'guards' expressions below
public abstract class TemporaryVarReferenceExprNode extends ExprNode {
    public static TemporaryVarReferenceExprNode create(FrameSlot frameSlot) {
        return TemporaryVarReferenceExprNodeGen.create(frameSlot);
    }

    protected abstract FrameSlot getFrameSlot();

    @Specialization(guards = "getFrameSlot().getKind() == Boolean")
    protected boolean readBoolean(VirtualFrame frame) {
        return FrameUtil.getBooleanSafe(frame, getFrameSlot());
    }

    @Specialization(guards = "getFrameSlot().getKind() == Int")
    protected int readInt(VirtualFrame frame) {
        return FrameUtil.getIntSafe(frame, getFrameSlot());
    }

    @Specialization
    protected Object readObject(VirtualFrame frame) {
        return FrameUtil.getObjectSafe(frame, getFrameSlot());
    }
}
