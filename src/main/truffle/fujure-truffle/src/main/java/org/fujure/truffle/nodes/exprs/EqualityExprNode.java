package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class EqualityExprNode extends BinaryExprNode {
    public static EqualityExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return EqualityExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected boolean booleansEqual(boolean leftValue, boolean rightValue) {
        return leftValue == rightValue;
    }

    @Specialization
    protected boolean charsEqual(char leftValue, char rightValue) {
        return leftValue == rightValue;
    }

    @Specialization
    protected boolean intsEqual(int leftValue, int rightValue) {
        return leftValue == rightValue;
    }

    @Specialization
    protected boolean objectsEqual(Object leftValue, Object rightValue) {
        return leftValue.equals(rightValue);
    }
}
