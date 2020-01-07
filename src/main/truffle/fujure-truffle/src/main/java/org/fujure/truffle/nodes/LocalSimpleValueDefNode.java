package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleBindings;
import org.fujure.truffle.nodes.exprs.ExprNode;

public final class LocalSimpleValueDefNode extends LocalValueDefNode {
    private final String id;
    private final FujureTruffleBindings.ModuleBindings bindings;

    @Child
    private ExprNode initializer;

    public LocalSimpleValueDefNode(String id, FujureTruffleBindings.ModuleBindings bindings, ExprNode initializer) {
        this.id = id;
        this.bindings = bindings;
        this.initializer = initializer;
    }

    @Override
    public void register(VirtualFrame frame) {
        Object result = this.initializer.executeGeneric(frame);
        bindings.register(id, result);
    }

    @Override
    public void deregister(VirtualFrame frame) {
        bindings.remove(id);
    }
}
