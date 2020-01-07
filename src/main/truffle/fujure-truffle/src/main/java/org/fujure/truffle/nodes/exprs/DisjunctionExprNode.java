package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public final class DisjunctionExprNode extends ExprNode {
    @Child
    private ExprNode leftDisjunct;

    @Child
    private ExprNode rightDisjunct;

    public DisjunctionExprNode(ExprNode leftDisjunct, ExprNode rightDisjunct) {
        this.leftDisjunct = leftDisjunct;
        this.rightDisjunct = rightDisjunct;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            return this.executeBoolean(frame);
        } catch (UnexpectedResultException e) {
            // should not happen (Fujure is statically typed)
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new UnsupportedSpecializationException(this, new Node[]{ this.leftDisjunct, this.rightDisjunct }, e.getResult());
        }
    }

    @Override
    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        boolean leftValue = leftDisjunct.executeBoolean(frame);
        if (leftValue) {
            // short-circuit evaluation
            return true;
        }

        return rightDisjunct.executeBoolean(frame);
    }
}
