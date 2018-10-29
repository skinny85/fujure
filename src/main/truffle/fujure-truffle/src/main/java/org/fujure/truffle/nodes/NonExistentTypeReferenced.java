package org.fujure.truffle.nodes;

import org.fujure.fbc.ast.TypeReference;

import static java.lang.String.format;

public final class NonExistentTypeReferenced extends Exception {
    public final TypeReference reference;

    public NonExistentTypeReferenced(TypeReference reference) {
        super(format("Referenced type '%s' does not exist", reference.inStringForm()));
        this.reference = reference;
    }
}
