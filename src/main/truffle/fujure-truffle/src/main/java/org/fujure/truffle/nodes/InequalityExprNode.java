package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class InequalityExprNode extends BinaryExprNode {
    public static InequalityExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return InequalityExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean booleansNotEqual(boolean leftValue, boolean rightValue) {
        return leftValue != rightValue;
    }

    @Specialization
    protected boolean charsNotEqual(char leftValue, char rightValue) {
        return leftValue != rightValue;
    }

    @Specialization
    protected boolean intsNotEqual(int leftValue, int rightValue) {
        return leftValue != rightValue;
    }

    @Specialization
    protected boolean objectsNotEqual(Object leftValue, Object rightValue) {
        return !leftValue.equals(rightValue);
    }
}
