package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class LesserEqualExprNode extends BinaryExprNode {
    public static LesserEqualExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return LesserEqualExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean lessThanOrEqual(int leftValue, int rightValue) {
        return leftValue <= rightValue;
    }
}
