package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.nodes.exprs.ExprNode;

public final class SimpleValueDefNode extends ValueDefNode {
    @Child
    private ExprNode initializer;

    public SimpleValueDefNode(String id, ExprNode initializer) {
        super(id);
        this.initializer = initializer;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return initializer.executeGeneric(frame);
    }
}
