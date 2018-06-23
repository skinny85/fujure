package org.fujure.truffle;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.TruffleObject;

public final class FujureTruffleValue implements TruffleObject {
    @Override
    public ForeignAccess getForeignAccess() {
        return FujureTruffleBindingsMessageResolutionForeign.ACCESS;
    }
}
