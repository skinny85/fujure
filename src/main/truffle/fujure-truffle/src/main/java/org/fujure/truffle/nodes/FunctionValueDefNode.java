package org.fujure.truffle.nodes;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleLanguage;
import org.fujure.truffle.nodes.exprs.ExprNode;
import org.fujure.truffle.runtime.FujureFunctionObject;

public final class FunctionValueDefNode extends ValueDefNode {
    private final FujureTruffleLanguage fujureTruffleLanguage;
    private final FrameDescriptor frameDescriptor;

    @Child
    private ExprNode body;

    public FunctionValueDefNode(FujureTruffleLanguage fujureTruffleLanguage, FrameDescriptor frameDescriptor,
            String id, ExprNode body) {
        super(id);

        this.fujureTruffleLanguage = fujureTruffleLanguage;
        this.frameDescriptor = frameDescriptor;
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return new FujureFunctionObject(Truffle.getRuntime().createCallTarget(
                new RootFunctionNode(this.fujureTruffleLanguage, this.frameDescriptor, this.body)));
    }
}
