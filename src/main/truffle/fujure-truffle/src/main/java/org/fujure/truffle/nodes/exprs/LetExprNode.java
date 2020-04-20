package org.fujure.truffle.nodes.exprs;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.nodes.TemporaryVariableDeclNode;

import java.util.List;

public final class LetExprNode extends ExprNode {
    @Children
    private final TemporaryVariableDeclNode[] temporaryDeclarations;

    @Child
    private ExprNode expr;

    public LetExprNode(List<TemporaryVariableDeclNode> temporaryDeclarations, ExprNode expr) {
        this.temporaryDeclarations = temporaryDeclarations.toArray(new TemporaryVariableDeclNode[0]);
        this.expr = expr;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        for (TemporaryVariableDeclNode temporaryDeclaration : temporaryDeclarations) {
            temporaryDeclaration.executeDeclaration(frame);
        }

        return expr.executeGeneric(frame);
    }
}
