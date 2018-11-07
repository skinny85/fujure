package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.truffle.DefValidationResult;
import org.fujure.truffle.runtime.Unit;

public final class UnitLiteralExprNode extends ExprNode {
    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        return new DefValidationResult.Correct(BuiltInTypes.INSTANCE.getUnit());
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return Unit.INSTANCE;
    }
}
