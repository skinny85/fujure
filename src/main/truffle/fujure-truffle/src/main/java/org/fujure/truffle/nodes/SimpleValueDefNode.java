package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import org.fujure.fbc.analyze.BuiltInTypes;
import org.fujure.fbc.analyze.QualifiedType;
import org.fujure.fbc.ast.TypeReference;
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
    public Object execute(VirtualFrame frame) throws
            UnresolvedReferenceException, InvalidReferenceException, TypeMismatchException {
        Optional<QualifiedType> maybeDeclaredType = Optional.empty();
        if (declaredTypeReference.isPresent()) {
            maybeDeclaredType = findType(declaredTypeReference.get());
            if (!maybeDeclaredType.isPresent()) {
                throw new UnresolvedReferenceException(declaredTypeReference.get().inStringForm());
            }
        }

        Object value = initializer.executeGeneric(frame);

        Optional<QualifiedType> maybeValueType = establishTypeOfValue(value);
        if (maybeDeclaredType.isPresent() && maybeValueType.isPresent()) {
            // ToDO handle unknown value type?
            QualifiedType valueType = maybeValueType.get();
            QualifiedType declaredType = maybeDeclaredType.get();
            if (!valueType.equals(declaredType))
                throw new TypeMismatchException(declaredType, valueType);
        }

        return value;
    }

    private Optional<QualifiedType> findType(TypeReference typeReference) {
        return Optional.ofNullable(contextReference.get().findType(typeReference));
    }

    private Optional<QualifiedType> establishTypeOfValue(Object value) {
        if (value instanceof Integer) {
            return Optional.of(BuiltInTypes.INSTANCE.getInt());
        } else if (value instanceof String) {
            return Optional.of(BuiltInTypes.INSTANCE.getString());
        } else {
            return Optional.empty();
        }
    }
}
