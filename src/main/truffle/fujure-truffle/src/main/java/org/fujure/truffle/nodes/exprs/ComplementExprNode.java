package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class ComplementExprNode extends UnaryExprNode {
    public static ComplementExprNode of(ExprNode operand) {
        return ComplementExprNodeGen.create(operand);
    }

    @Specialization
    protected boolean complement(boolean value) {
        return !value;
    }
}
