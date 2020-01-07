package org.fujure.truffle.nodes.exprs.builtins;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;

public abstract class BuiltInAbsFunctionBodyExpr extends BuiltInFunctionBodyExpr {
    public static NodeFactory<BuiltInAbsFunctionBodyExpr> getFactory() {
        return BuiltInAbsFunctionBodyExprFactory.getInstance();
    }

    @Specialization
    public int abs(int value) {
        return value >= 0 ? value : -value;
    }
}
