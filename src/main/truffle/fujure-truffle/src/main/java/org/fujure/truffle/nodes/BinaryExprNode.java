package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;

@NodeChildren({
    @NodeChild(value = "leftOperand", type = ExprNode.class),
    @NodeChild(value = "rightOperand", type = ExprNode.class),
})
public abstract class BinaryExprNode extends ExprNode {
}
