package org.fujure.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class LocalValueDefNode extends Node {
    public abstract void register(VirtualFrame frame);

    public abstract void deregister(VirtualFrame frame);
}
