package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class SimpleValueDefNode extends ValueDefNode {
    @Child
    private ExprNode initializer;

    public SimpleValueDefNode(String id, ExprNode initializer) {
        super(id);
        this.initializer = initializer;
    }

    @Override
    public Object execute(VirtualFrame frame) throws
            UnresolvedReferenceException, InvalidReferenceException {
        return initializer.execute(frame);
    }
}
