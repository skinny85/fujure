package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class NegationExprNode extends UnaryExprNode {
    public static NegationExprNode of(ExprNode operand) {
        return NegationExprNodeGen.create(operand);
    }

    @Specialization
    protected int negate(int value) {
        return -value;
    }
}
