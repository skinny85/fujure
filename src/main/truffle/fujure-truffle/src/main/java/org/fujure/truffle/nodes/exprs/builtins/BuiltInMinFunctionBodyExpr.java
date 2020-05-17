package org.fujure.truffle.nodes.exprs.builtins;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;

public abstract class BuiltInMinFunctionBodyExpr extends BuiltInFunctionBodyExpr {
    public static NodeFactory<BuiltInMinFunctionBodyExpr> getFactory() {
        return BuiltInMinFunctionBodyExprFactory.getInstance();
    }

    @Specialization
    public int min(int v1, int v2) {
        return v1 < v2 ? v1 : v2;
    }
}
