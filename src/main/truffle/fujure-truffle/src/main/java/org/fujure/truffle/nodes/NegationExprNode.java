package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class NegationExprNode extends UnaryExprNode {
    @Specialization
    protected boolean negate(boolean value) {
        return !value;
    }
}
