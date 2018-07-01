package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class ExprNode extends Node {
    public abstract Object execute(VirtualFrame frame) throws UnresolvedReferenceException;
}
