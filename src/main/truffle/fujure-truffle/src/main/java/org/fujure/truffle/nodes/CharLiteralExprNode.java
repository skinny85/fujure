package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.truffle.DefValidationResult;

public final class CharLiteralExprNode extends ExprNode {
    private final char value;

    public CharLiteralExprNode(char value) {
        this.value = value;
    }

    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        return new DefValidationResult.Correct(BuiltInTypes.INSTANCE.getChar());
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public char executeCharacter(VirtualFrame frame) {
        return value;
    }
}
