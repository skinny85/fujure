package org.fujure.truffle.nodes;

import org.fujure.fbc.analyze.QualifiedType;

public final class TypeMismatchException extends Throwable {
    public final QualifiedType declaredType;
    public final QualifiedType actualType;

    public TypeMismatchException(QualifiedType declaredType, QualifiedType actualType) {
        this.declaredType = declaredType;
        this.actualType = actualType;
    }
}
