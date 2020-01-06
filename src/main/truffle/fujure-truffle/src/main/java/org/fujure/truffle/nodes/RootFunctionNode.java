package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import org.fujure.truffle.FujureTruffleLanguage;

public final class RootFunctionNode extends RootNode {
    @Child
    private ExprNode functionBodyNode;

    public RootFunctionNode(FujureTruffleLanguage language, FrameDescriptor frameDescriptor, ExprNode functionBodyNode) {
        super(language, frameDescriptor);

        this.functionBodyNode = functionBodyNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return this.functionBodyNode.executeGeneric(frame);
    }
}
