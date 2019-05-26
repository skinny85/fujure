package org.fujure.truffle.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public final class IfExprNode extends ExprNode {
    @Child
    private ExprNode condition;

    @Child
    private ExprNode thenPart;

    @Child
    private ExprNode elsePart;

    public IfExprNode(ExprNode condition, ExprNode thenPart, ExprNode elsePart) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        boolean conditionResult;
        try {
            conditionResult = condition.executeBoolean(frame);
        } catch (UnexpectedResultException e) {
            // should not happen (Fujure is statically typed)
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new UnsupportedSpecializationException(this, new Node[]{
                    this.condition, this.thenPart, this.elsePart,
            }, e.getResult());
        }

        return conditionResult ? thenPart.executeGeneric(frame) : elsePart.executeGeneric(frame);
    }
}
