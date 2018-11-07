package org.fujure.truffle.nodes;

import com.oracle.truffle.api.nodes.Node;
import org.fujure.truffle.DefValidationResult;

public abstract class DefNode extends Node {
    public abstract DefValidationResult validate();
}
