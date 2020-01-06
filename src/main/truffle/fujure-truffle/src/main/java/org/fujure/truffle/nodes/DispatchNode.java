package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import org.fujure.truffle.FujureTypeSystem;
import org.fujure.truffle.runtime.FujureFunctionObject;

@TypeSystemReference(FujureTypeSystem.class)
public abstract class DispatchNode extends Node {
    public abstract Object executeDispatch(Object function, Object[] arguments);

    @Specialization
    protected static Object doIndirect(FujureFunctionObject function, Object[] arguments,
            @Cached("create()") IndirectCallNode callNode) {
        return callNode.call(function.callTarget, arguments);
    }
}
