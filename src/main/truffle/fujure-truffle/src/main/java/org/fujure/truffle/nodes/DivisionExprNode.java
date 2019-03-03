package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class DivisionExprNode extends BinaryExprNode {
    public static DivisionExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return DivisionExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int divide(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }
}
