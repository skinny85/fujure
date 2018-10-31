package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.runtime.Unit;

public final class UnitLiteralExprNode extends ExprNode {
    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return Unit.INSTANCE;
    }
}
