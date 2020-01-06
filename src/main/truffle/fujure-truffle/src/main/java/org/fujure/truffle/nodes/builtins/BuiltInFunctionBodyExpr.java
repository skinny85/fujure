package org.fujure.truffle.nodes.builtins;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import org.fujure.truffle.nodes.ExprNode;

@NodeChild(value = "arguments", type = ExprNode[].class)
@GenerateNodeFactory
public abstract class BuiltInFunctionBodyExpr extends ExprNode {
}
