package org.fujure.truffle.nodes.exprs.builtins.IO;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr;
import org.fujure.truffle.runtime.IO;

public abstract class IOChainBuiltInFunction extends BuiltInFunctionBodyExpr {
    public static NodeFactory<IOChainBuiltInFunction> getFactory() {
        return IOChainBuiltInFunctionFactory.getInstance();
    }

    @Specialization
    public IO<?> putStrLn(IO<?> first, IO<?> second) {
        return first.chain(second);
    }
}
