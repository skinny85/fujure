package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

import java.util.List;

public final class LetExprNode extends ExprNode {
    @Children
    private final LocalValueDefNode[] localValues;

    @Child
    private ExprNode expr;

//    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

//    private final Module module;

    public LetExprNode(List<LocalValueDefNode> localValues, ExprNode expr/*, FujureTruffleLanguage fujureTruffleLanguage*/) {
        this.localValues = localValues.toArray(new LocalValueDefNode[0]);
        this.expr = expr;
//        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        // I. On construction of a LetExprNode:
        //   - Create a new FrameDescriptor
        //   - Push the new FrameDescriptor onto the Context's Stack
        //   - For each declaration:
        //     - create an new FrameSlot, with the name of the declaration, from that FrameDescriptor
        //     - recursively translate the initializer expression
        //     - create a new LocalSimpleValueDefNode, passing in the created FrameSlot and the translated expression
        //     - save the FrameSlot in the Context (perhaps not needed...? we'll see)
        //   - Translate the expression
        //   - Pop the Context's Stack
        // II. Change the construction of reference expressions:
        //   - When translating a reference expression, ask the Context if it's a local reference.
        //     If 'yes', create a new LocalReferenceExprNode, passing the found FrameSlot.
        //     If 'no', create the standard ReferenceExprNode.
        // III. On execution of a LetExprNode:
        //   - For each declaration:
        //     - execute the initializer expression
        //     - save the result of the initializer in the Frame, under the FrameSlot
        //   - Execute the expression
        //   - For each declaration:
        //     - remove its FrameSlot from the Frame
        // IV. On execution of a LocalReferenceExprNode:
        //   - Read the value of the FrameSlot from the Frame

        for (LocalValueDefNode localValue : localValues) {
            localValue.register(frame);
        }

        Object ret = expr.executeGeneric(frame);

        for (LocalValueDefNode localValue : localValues) {
            localValue.deregister(frame);
        }

        return ret;
    }
}
