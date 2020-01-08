package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class PositationExprNode extends UnaryExprNode {
    public static PositationExprNode of(ExprNode operand) {
        return PositationExprNodeGen.create(operand);
    }

    @Specialization
    protected int positate(int value) {
        return value;
    }
}
