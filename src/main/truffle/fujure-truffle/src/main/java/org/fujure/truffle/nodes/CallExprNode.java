package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

import java.util.List;

public final class CallExprNode extends ExprNode {
    @Child private ExprNode functionNode;
    @Children private final ExprNode[] argumentNodes;
    @Child private DispatchNode dispatchNode;

    public CallExprNode(ExprNode functionNode, List<ExprNode> argumentNodes) {
        this.functionNode = functionNode;
        this.argumentNodes = argumentNodes.toArray(new ExprNode[0]);
        this.dispatchNode = DispatchNodeGen.create();
    }

    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) {
        Object function = functionNode.executeGeneric(frame);

        Object[] argumentValues = new Object[argumentNodes.length];
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i] = argumentNodes[i].executeGeneric(frame);
        }

        return this.dispatchNode.executeDispatch(function, argumentValues);
    }
}
