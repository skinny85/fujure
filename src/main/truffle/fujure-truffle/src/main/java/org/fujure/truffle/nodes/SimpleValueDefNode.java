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

    private final Optional<TypeReference> declaredType;
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;

    public SimpleValueDefNode(String id, TypeReference declaredType, ExprNode initializer,
            FujureTruffleLanguage fujureTruffleLanguage) {
        super(id);
        this.initializer = initializer;
        this.declaredType = Optional.ofNullable(declaredType);
        this.contextReference = fujureTruffleLanguage.getContextReference();
    }

    @Override
    public Object execute(VirtualFrame frame) throws
            UnresolvedReferenceException, InvalidReferenceException, TypeMismatchException {
        Object value = initializer.executeGeneric(frame);
        if (declaredType.isPresent()) {
            Optional<QualifiedType> declaredQualifiedType = Optional.ofNullable(contextReference.get().findType(declaredType.get()));
            Optional<QualifiedType> valueQualifiedType = establishTypeOfValue(value);
            if (valueQualifiedType.isPresent()) {
                QualifiedType vqt = valueQualifiedType.get();
                // ToDo handle an unrecognized declared type error
                QualifiedType dqt = declaredQualifiedType.get();
                if (!vqt.equals(dqt))
                   throw new TypeMismatchException(dqt, vqt);
            }
        }
        return value;
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
