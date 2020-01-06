package org.fujure.truffle.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.TruffleObject;

public final class FujureFunctionObject implements TruffleObject {
    public final RootCallTarget callTarget;

    public static boolean isInstance(TruffleObject obj) {
        return obj instanceof FujureFunctionObject;
    }

    public FujureFunctionObject(RootCallTarget callTarget) {
        this.callTarget = callTarget;
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return FujureFunctionObjectMessageResolutionForeign.ACCESS;
    }

    @MessageResolution(receiverType = FujureFunctionObject.class)
    static final class FujureFunctionObjectMessageResolution {
    }
}
