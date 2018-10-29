package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.ast.ValueReference;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;
import org.fujure.truffle.LookupResult;

public final class ReferenceExprNode extends ExprNode {
    private final ValueReference reference;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(ValueReference reference, FujureTruffleLanguage fujureTruffleLanguage) {
        this.reference = reference;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws
            UnresolvedReference, InvalidReference {
        LookupResult lookup = contextReference.get().lookup(reference);
        if (lookup instanceof LookupResult.RefNotFound) {
            throw new UnresolvedReference(reference);
        } else if (lookup instanceof LookupResult.InvalidRefFound) {
            throw new InvalidReference(reference);
        } else {
            return ((LookupResult.ValidRefFound)lookup).getValue();
        }
    }
}
