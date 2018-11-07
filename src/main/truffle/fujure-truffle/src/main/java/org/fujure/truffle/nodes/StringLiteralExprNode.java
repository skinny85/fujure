package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.truffle.DefValidationResult;

public final class StringLiteralExprNode extends ExprNode {
    private final String value;

    public StringLiteralExprNode(String value) {
        this.value = value;
    }

    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        return new DefValidationResult.Correct(BuiltInTypes.INSTANCE.getString());
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
