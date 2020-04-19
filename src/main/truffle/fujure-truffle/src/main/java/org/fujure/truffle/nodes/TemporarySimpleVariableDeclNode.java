package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.nodes.exprs.ExprNode;

@NodeChild(value = "initializer", type = ExprNode.class)
@NodeField(name = "frameSlot", type = FrameSlot.class)
public abstract class TemporarySimpleVariableDeclNode extends TemporaryVariableDeclNode {
    public static TemporarySimpleVariableDeclNode create(ExprNode initializer, FrameSlot frameSlot) {
        return TemporarySimpleVariableDeclNodeGen.create(initializer, frameSlot);
    }

    protected abstract FrameSlot getFrameSlot();

    @Specialization
    protected void declareBoolean(VirtualFrame frame, boolean value) {
        this.getFrameSlot().setKind(FrameSlotKind.Boolean);
        frame.setBoolean(this.getFrameSlot(), value);
    }

    @Specialization
    protected void declareInt(VirtualFrame frame, int value) {
        this.getFrameSlot().setKind(FrameSlotKind.Int);
        frame.setInt(this.getFrameSlot(), value);
    }

    @Specialization
    protected void declareObject(VirtualFrame frame, Object value) {
        this.getFrameSlot().setKind(FrameSlotKind.Object);
        frame.setObject(this.getFrameSlot(), value);
    }
}
