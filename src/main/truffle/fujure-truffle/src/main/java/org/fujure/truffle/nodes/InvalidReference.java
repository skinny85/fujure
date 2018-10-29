package org.fujure.truffle.nodes;

import org.fujure.fbc.ast.ValueReference;

import static java.lang.String.format;

public final class InvalidReference extends Exception {
    public final ValueReference reference;

    public InvalidReference(ValueReference reference) {
        super(format("Reference '%s' was found but has an invalid definition", reference.inStringForm()));
        this.reference = reference;
    }
}
