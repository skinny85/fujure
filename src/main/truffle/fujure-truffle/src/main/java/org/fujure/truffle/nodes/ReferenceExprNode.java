package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

import java.util.Optional;

public final class ReferenceExprNode extends ExprNode {
    private final String ref;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(String ref, FujureTruffleLanguage fujureTruffleLanguage) {
        this.ref = ref;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object execute(VirtualFrame frame) throws UnresolvedReferenceException {
        Optional<Optional<Object>> foundResult = contextReference.get().lookup(ref);
        if (!foundResult.isPresent())
            throw new UnresolvedReferenceException(ref);
        Optional<Object> correctResult = foundResult.get();
        return correctResult.orElse(null);
    }
}