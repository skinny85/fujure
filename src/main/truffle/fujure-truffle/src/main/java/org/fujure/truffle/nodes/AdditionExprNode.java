package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class AdditionExprNode extends BinaryExprNode {
    public static AdditionExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return AdditionExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int add(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }
}
