package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.CompleteType;
import org.fujure.truffle.nodes.exprs.ExprNode;

public final class SimpleValueDefNode extends ValueDefNode {
    public final CompleteType type;

    @Child
    private ExprNode initializer;

    public SimpleValueDefNode(String id, ExprNode initializer, CompleteType type) {
        super(id);

        this.initializer = initializer;
        this.type = type;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return initializer.executeGeneric(frame);
    }
}
