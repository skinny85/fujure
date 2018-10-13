package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;
import org.fujure.truffle.LookupResult;

public final class ReferenceExprNode extends ExprNode {
    private final String ref;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(String ref, FujureTruffleLanguage fujureTruffleLanguage) {
        this.ref = ref;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws
            UnresolvedReferenceException, InvalidReferenceException {
        LookupResult lookup = contextReference.get().lookup(ref);
        if (lookup instanceof LookupResult.RefNotFound) {
            throw new UnresolvedReferenceException(ref);
        } else if (lookup instanceof LookupResult.InvalidRefFound) {
            throw new InvalidReferenceException(ref);
        } else {
            return ((LookupResult.ValidRefFound)lookup).getValue();
        }
    }
}
