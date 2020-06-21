package org.fujure.truffle.nodes.exprs.builtins.Int;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr;

public abstract class IntMinBuiltInFunction extends BuiltInFunctionBodyExpr {
    public static NodeFactory<IntMinBuiltInFunction> getFactory() {
        return IntMinBuiltInFunctionFactory.getInstance();
    }

    @Specialization
    public int min(int v1, int v2) {
        return v1 < v2 ? v1 : v2;
    }
}
