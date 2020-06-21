package org.fujure.truffle.nodes.exprs.builtins.Int;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr;

public abstract class IntMaxBuiltInFunction extends BuiltInFunctionBodyExpr {
    public static NodeFactory<IntMaxBuiltInFunction> getFactory() {
        return IntMaxBuiltInFunctionFactory.getInstance();
    }

    @Specialization
    public int max(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }
}
