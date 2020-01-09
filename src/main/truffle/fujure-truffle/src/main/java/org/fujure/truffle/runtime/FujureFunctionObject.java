package org.fujure.truffle.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.Resolve;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;
import org.fujure.truffle.nodes.DispatchNode;
import org.fujure.truffle.nodes.DispatchNodeGen;

public final class FujureFunctionObject implements TruffleObject {
    public static boolean isInstance(TruffleObject obj) {
        return obj instanceof FujureFunctionObject;
    }

    public final RootCallTarget callTarget;

    public FujureFunctionObject(RootCallTarget callTarget) {
        this.callTarget = callTarget;
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return FujureFunctionObjectMessageResolutionForeign.ACCESS;
    }

    @MessageResolution(receiverType = FujureFunctionObject.class)
    static final class FujureFunctionObjectMessageResolution {
        @Resolve(message = "EXECUTE")
        abstract static class ExecuteNode extends Node {
            @Child
            private DispatchNode dispatchNode = DispatchNodeGen.create();

            public Object access(FujureFunctionObject receiver, Object[] arguments) {
                return dispatchNode.executeDispatch(receiver, arguments);
            }
        }
    }
}
