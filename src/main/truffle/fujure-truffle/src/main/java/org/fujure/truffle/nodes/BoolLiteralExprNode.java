package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.truffle.DefValidationResult;

public final class BoolLiteralExprNode extends ExprNode {
    private final boolean value;

    public BoolLiteralExprNode(boolean value) {
        this.value = value;
    }

    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        return new DefValidationResult.Correct(BuiltInTypes.INSTANCE.getBool());
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public boolean executeBoolean(VirtualFrame frame) {
        return value;
    }
}
