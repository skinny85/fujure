package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.ErrorContext;
import org.fujure.fbc.analyze.QualifiedType;
import org.fujure.fbc.analyze.SemanticError;
import org.fujure.fbc.ast.TypeReference;
import org.fujure.truffle.DefValidationResult;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

import java.util.Optional;

public final class SimpleValueDefNode extends ValueDefNode {
    @Child
    private ExprNode initializer;

    private final Optional<TypeReference> declaredTypeReference;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public SimpleValueDefNode(String id, TypeReference declaredTypeReference, ExprNode initializer,
            FujureTruffleLanguage fujureTruffleLanguage) {
        super(id);
        this.initializer = initializer;
        this.declaredTypeReference = Optional.ofNullable(declaredTypeReference);
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public DefValidationResult validate() {
        ErrorContext.ValueDefinition errorContext = new ErrorContext.ValueDefinition(id);
        DefValidationResult initializerValidation = initializer.validate(errorContext);

        if (declaredTypeReference.isPresent()) {
            Optional<QualifiedType> maybeDeclaredType = findType(declaredTypeReference.get());
            if (!maybeDeclaredType.isPresent()) {
                initializerValidation = initializerValidation.withError(
                        new SemanticError.TypeNotFound(
                                errorContext,
                                declaredTypeReference.get()));
            } else if (initializerValidation instanceof DefValidationResult.Correct) {
                QualifiedType declaredType = maybeDeclaredType.get();
                QualifiedType initializerType = ((DefValidationResult.Correct) initializerValidation).getType();
                if (!declaredType.equals(initializerType))
                    initializerValidation = initializerValidation.withError(
                        new SemanticError.TypeMismatch(
                                errorContext,
                                declaredType, initializerType));
            }
        }

        return initializerValidation;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return initializer.executeGeneric(frame);
    }

    private Optional<QualifiedType> findType(TypeReference typeReference) {
        return Optional.ofNullable(contextReference.get().findType(typeReference));
    }
}
