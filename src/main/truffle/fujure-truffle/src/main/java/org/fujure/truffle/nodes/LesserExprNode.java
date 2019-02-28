package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class LesserExprNode extends BinaryExprNode {
    public static LesserExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return LesserExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean lessThan(int leftValue, int rightValue) {
        return leftValue < rightValue;
    }
}
