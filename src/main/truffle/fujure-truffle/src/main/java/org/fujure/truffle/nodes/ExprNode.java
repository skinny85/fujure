package org.fujure.truffle.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.fujure.truffle.FujureTypeSystem;
import org.fujure.truffle.FujureTypeSystemGen;

@TypeSystemReference(FujureTypeSystem.class)
public abstract class ExprNode extends Node {
    public abstract Object executeGeneric(VirtualFrame frame);

    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        return FujureTypeSystemGen.expectBoolean(this.executeGeneric(frame));
    }

    public char executeCharacter(VirtualFrame frame) throws UnexpectedResultException {
        return FujureTypeSystemGen.expectCharacter(this.executeGeneric(frame));
    }

    public int executeInteger(VirtualFrame frame) throws UnexpectedResultException {
        return FujureTypeSystemGen.expectInteger(this.executeGeneric(frame));
    }

    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return FujureTypeSystemGen.expectString(this.executeGeneric(frame));
    }
}
