package org.fujure.truffle.nodes;

import static java.lang.String.format;

public final class InvalidReferenceException extends Exception {
    public final String ref;

    public InvalidReferenceException(String ref) {
        super(format("Reference '%s' was found but has an invalid definition", ref));
        this.ref = ref;
    }
}
