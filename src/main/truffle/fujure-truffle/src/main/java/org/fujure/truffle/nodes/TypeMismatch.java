package org.fujure.truffle.nodes;

import org.fujure.fbc.analyze.QualifiedType;

import static java.lang.String.format;

public final class TypeMismatch extends Exception {
    public final QualifiedType declaredType;
    public final QualifiedType actualType;

    public TypeMismatch(QualifiedType declaredType, QualifiedType actualType) {
        super(format("Declared type was: %s, but actual type is: %s",
                declaredType.inStringForm(), actualType.inStringForm()));
        this.declaredType = declaredType;
        this.actualType = actualType;
    }
}
