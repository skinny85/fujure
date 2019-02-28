package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class GreaterExprNode extends BinaryExprNode {
    public static GreaterExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return GreaterExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean greaterThan(int leftValue, int rightValue) {
        return leftValue > rightValue;
    }
}
