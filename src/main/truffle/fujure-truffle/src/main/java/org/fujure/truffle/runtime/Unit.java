package org.fujure.truffle.runtime;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.TruffleObject;

public final class Unit implements TruffleObject {
    public static boolean isInstance(TruffleObject obj) {
        return obj instanceof Unit;
    }

    public static final Unit INSTANCE = new Unit();

    private Unit() {
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return UnitMessageResolutionForeign.ACCESS;
    }

    @MessageResolution(receiverType = Unit.class)
    static final class UnitMessageResolution {
    }
}
