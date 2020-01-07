package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class GreaterEqualExprNode extends BinaryExprNode {
    public static GreaterEqualExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return GreaterEqualExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean greaterThanOrEqual(int leftValue, int rightValue) {
        return leftValue >= rightValue;
    }
}
