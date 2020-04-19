package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import org.fujure.truffle.FujureTypeSystem;

@TypeSystemReference(FujureTypeSystem.class)
public abstract class TemporaryVariableDeclNode extends Node {
    // the Truffle DSL forces the name to start with 'execute'
    public abstract void executeDeclaration(VirtualFrame frame);
}
