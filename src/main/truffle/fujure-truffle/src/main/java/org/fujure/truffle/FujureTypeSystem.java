package org.fujure.truffle;

import com.oracle.truffle.api.dsl.TypeSystem;
import org.fujure.truffle.runtime.Unit;

@TypeSystem({
        boolean.class,
        char.class,
        int.class,
        String.class,
        Unit.class,
})
public class FujureTypeSystem {
}
