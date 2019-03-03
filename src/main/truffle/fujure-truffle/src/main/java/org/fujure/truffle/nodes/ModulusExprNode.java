package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class ModulusExprNode extends BinaryExprNode {
    public static ModulusExprNode of(ExprNode leftOperand, ExprNode rightOperand) {
        return ModulusExprNodeGen.create(leftOperand, rightOperand);
    }

    @Specialization
    protected int modulo(int leftValue, int rightValue) {
        return leftValue % rightValue;
    }
}
