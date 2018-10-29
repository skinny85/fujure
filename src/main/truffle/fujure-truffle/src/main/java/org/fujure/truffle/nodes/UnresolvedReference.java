package org.fujure.truffle.nodes;

import org.fujure.fbc.ast.ValueReference;

import static java.lang.String.format;

public final class UnresolvedReference extends Exception {
    public final ValueReference reference;

    public UnresolvedReference(ValueReference reference) {
        super(format("Unresolved reference: '%s'", reference.inStringForm()));
        this.reference = reference;
    }
}
