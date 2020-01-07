package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class AdditionOrConcatenationExprNode extends BinaryExprNode {
    public static AdditionOrConcatenationExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return AdditionOrConcatenationExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int add(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    @Specialization
    protected String concatenate(String leftValue, String rightValue) {
        return leftValue + rightValue;
    }
}
