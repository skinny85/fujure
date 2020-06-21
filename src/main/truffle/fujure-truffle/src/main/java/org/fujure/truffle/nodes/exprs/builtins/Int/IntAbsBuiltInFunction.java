package org.fujure.truffle.nodes.exprs.builtins.Int;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr;

public abstract class IntAbsBuiltInFunction extends BuiltInFunctionBodyExpr {
    public static NodeFactory<IntAbsBuiltInFunction> getFactory() {
        return IntAbsBuiltInFunctionFactory.getInstance();
    }

    @Specialization
    public int abs(int value) {
        return value >= 0 ? value : -value;
    }
}
