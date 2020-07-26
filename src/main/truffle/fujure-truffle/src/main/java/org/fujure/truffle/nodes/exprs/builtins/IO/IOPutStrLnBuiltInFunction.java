package org.fujure.truffle.nodes.exprs.builtins.IO;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import org.fujure.truffle.nodes.exprs.builtins.BuiltInFunctionBodyExpr;
import org.fujure.truffle.runtime.IO;
import org.fujure.truffle.runtime.Unit;
import org.fujure.truffle.runtime.io.Effect;

public abstract class IOPutStrLnBuiltInFunction extends BuiltInFunctionBodyExpr {
    public static NodeFactory<IOPutStrLnBuiltInFunction> getFactory() {
        return IOPutStrLnBuiltInFunctionFactory.getInstance();
    }

    @Specialization
    public IO<Unit> putStrLn(String line) {
        return IO.of(new Effect.Print(line + "\n"));
    }
}
