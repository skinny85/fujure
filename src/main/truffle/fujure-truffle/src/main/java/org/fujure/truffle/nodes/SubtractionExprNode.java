package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class SubtractionExprNode extends BinaryExprNode {
    public static SubtractionExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return SubtractionExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int subtract(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }
}
