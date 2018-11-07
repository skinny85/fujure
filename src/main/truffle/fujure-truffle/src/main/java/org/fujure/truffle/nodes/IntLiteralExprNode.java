package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.truffle.DefValidationResult;

public final class IntLiteralExprNode extends ExprNode {
    private final int value;

    public IntLiteralExprNode(int value) {
        this.value = value;
    }

    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        return new DefValidationResult.Correct(BuiltInTypes.INSTANCE.getInt());
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInteger(VirtualFrame frame) {
        return value;
    }
}
