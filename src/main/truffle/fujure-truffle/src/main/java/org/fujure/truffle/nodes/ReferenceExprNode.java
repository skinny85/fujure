package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.fbc.analyze.QualifiedType;
import org.fujure.fbc.analyze.SemanticError;
import org.fujure.fbc.ast.ValueReference;
import org.fujure.truffle.DefValidationResult;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;
import org.fujure.truffle.Phase1LookupResult;

import java.util.Collections;

public final class ReferenceExprNode extends ExprNode {
    private final ValueReference reference;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public ReferenceExprNode(ValueReference reference, FujureTruffleLanguage fujureTruffleLanguage) {
        this.reference = reference;
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public DefValidationResult validate(ErrorContext errorContext) {
        Phase1LookupResult lookup = contextReference.get().phase1Lookup(reference);
        if (lookup instanceof Phase1LookupResult.RefNotFound) {
            return new DefValidationResult.Incorrect(Collections.singletonList(
                    new SemanticError.UnresolvedReference(errorContext, reference)));
        } else if (lookup instanceof Phase1LookupResult.InvalidRefFound) {
            // This is an interesting scenario - it means the reference was found, but its definition was incorrect.
            // We handle this case by returning an Incorrect result, but with an empty list of errors.
            return new DefValidationResult.Incorrect(Collections.emptyList());
        } else {
            QualifiedType type = ((Phase1LookupResult.ValidRefFound) lookup).getType();
            return new DefValidationResult.Correct(type);
        }
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return contextReference.get().phase2Lookup(reference);
    }
}
