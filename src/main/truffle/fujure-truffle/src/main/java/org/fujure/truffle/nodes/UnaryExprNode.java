package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.NodeChild;

@NodeChild(value = "operand", type = ExprNode.class)
public abstract class UnaryExprNode extends ExprNode {
}
