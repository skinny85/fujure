package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public final class ConjunctionExprNode extends ExprNode {
    @Child
    private ExprNode leftConjunct;

    @Child
    private ExprNode rightConjunct;

    public ConjunctionExprNode(ExprNode leftConjunct, ExprNode rightConjunct) {
        this.leftConjunct = leftConjunct;
        this.rightConjunct = rightConjunct;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            return this.executeBoolean(frame);
        } catch (UnexpectedResultException e) {
            // should not happen (Fujure is statically typed)
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new UnsupportedSpecializationException(this, new Node[]{ this.leftConjunct, this.rightConjunct}, e.getResult());
        }
    }

    @Override
    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        boolean leftValue = leftConjunct.executeBoolean(frame);
        if (!leftValue) {
            // short-circuit evaluation
            return false;
        }

        return rightConjunct.executeBoolean(frame);
    }
}
