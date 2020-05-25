package org.fujure.truffle.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.MessageResolution;
import com.oracle.truffle.api.interop.Resolve;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.Node;

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
        @Resolve(message = "IS_NULL")
        abstract static class IsNullNode extends Node {
            // the unused parameter is required by the Truffle DSL
            @CompilerDirectives.TruffleBoundary
            public boolean access(@SuppressWarnings("unused") Unit unit) {
                return true;
            }
        }
    }
}
