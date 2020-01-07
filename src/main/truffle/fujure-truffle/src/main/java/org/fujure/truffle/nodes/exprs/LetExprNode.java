package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.nodes.LocalValueDefNode;

import java.util.List;

public final class LetExprNode extends ExprNode {
    @Children
    private final LocalValueDefNode[] localValues;

    @Child
    private ExprNode expr;

    public LetExprNode(List<LocalValueDefNode> localValues, ExprNode expr) {
        this.localValues = localValues.toArray(new LocalValueDefNode[0]);
        this.expr = expr;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        for (LocalValueDefNode localValue : localValues) {
            localValue.register(frame);
        }

        Object ret = expr.executeGeneric(frame);

        for (LocalValueDefNode localValue : localValues) {
            localValue.deregister(frame);
        }

        return ret;
    }
}
