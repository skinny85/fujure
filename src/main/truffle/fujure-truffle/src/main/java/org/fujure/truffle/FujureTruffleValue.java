package org.fujure.truffle;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.TruffleObject;

public final class FujureTruffleValue implements TruffleObject {
    public static boolean isInstance(TruffleObject obj) {
        return obj instanceof FujureTruffleValue;
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return FujureTruffleValueMessageResolutionForeign.ACCESS;
    }

    @MessageResolution(receiverType = FujureTruffleValue.class)
    static final class FujureTruffleValueMessageResolution {
    }
}
