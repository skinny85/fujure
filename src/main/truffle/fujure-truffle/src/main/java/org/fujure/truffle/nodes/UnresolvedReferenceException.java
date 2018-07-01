package org.fujure.truffle.nodes;

import static java.lang.String.format;

public final class UnresolvedReferenceException extends Exception {
    public final String ref;

    public UnresolvedReferenceException(String ref) {
        super(format("Unresolved reference: '%s'", ref));
        this.ref = ref;
    }
}
