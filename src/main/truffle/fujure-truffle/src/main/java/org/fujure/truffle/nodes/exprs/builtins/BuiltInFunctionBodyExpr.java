package org.fujure.truffle.nodes.exprs.builtins;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import org.fujure.truffle.nodes.exprs.ExprNode;

@NodeChild(value = "arguments", type = ExprNode[].class)
@GenerateNodeFactory
public abstract class BuiltInFunctionBodyExpr extends ExprNode {
}
