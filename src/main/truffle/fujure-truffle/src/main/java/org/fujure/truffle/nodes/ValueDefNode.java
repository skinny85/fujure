package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class ValueDefNode extends DefNode {
    protected final String id;

    protected ValueDefNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract Object execute(VirtualFrame frame);
}
