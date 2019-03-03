package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MultiplicationExprNode extends BinaryExprNode {
    public static MultiplicationExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return MultiplicationExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int multiply(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }
}
