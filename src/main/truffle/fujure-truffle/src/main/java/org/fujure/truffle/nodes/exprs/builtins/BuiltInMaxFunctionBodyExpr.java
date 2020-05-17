package org.fujure.truffle.nodes.exprs.builtins;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;

public abstract class BuiltInMaxFunctionBodyExpr extends BuiltInFunctionBodyExpr {
    public static NodeFactory<BuiltInMaxFunctionBodyExpr> getFactory() {
        return BuiltInMaxFunctionBodyExprFactory.getInstance();
    }

    @Specialization
    public int max(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }
}
