package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.QualifiedType;
import org.fujure.truffle.nodes.exprs.ExprNode;

public final class SimpleValueDefNode extends ValueDefNode {
    public final QualifiedType type;

    @Child
    private ExprNode initializer;

    public SimpleValueDefNode(String id, ExprNode initializer, QualifiedType type) {
        super(id);

        this.initializer = initializer;
        this.type = type;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return initializer.executeGeneric(frame);
    }
}
