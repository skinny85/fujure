package org.fujure.truffle.test;

import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.graalvm.polyglot.PolyglotException;

public final class PolyglotAssertion extends
        AbstractThrowableAssert<PolyglotAssertion, PolyglotException> {
    public static PolyglotAssertion assertThatPolyglot(Throwable throwable) {
        Assertions.assertThat(throwable)
                .isInstanceOf(PolyglotException.class);
        return new PolyglotAssertion((PolyglotException) throwable);
    }

    public PolyglotAssertion(PolyglotException polyglotException) {
        super(polyglotException, PolyglotAssertion.class);
    }

    public PolyglotAssertion isGuestNonSyntaxError() {
        isGuestException();
        isNotAnInternalError();
        if (actual.isSyntaxError())
            failWithMessage("Expected isSyntaxError to be false, but was: true");

        return this;
    }

    public PolyglotAssertion isGuestSyntaxError() {
        isGuestException();
        isNotAnInternalError();
        if (!actual.isSyntaxError())
            failWithMessage("Expected isSyntaxError to be true, but was: false");

        return this;
    }

    public AbstractCharSequenceAssert<?, String> message() {
        return Assertions.assertThat(actual.getMessage());
    }

    private void isGuestException() {
        if (!actual.isGuestException())
            failWithMessage("Expected isGuestException to be true, but was: false");
    }

    private void isNotAnInternalError() {
        if (actual.isInternalError())
            failWithMessage("Expected isInternal to be false, but was: true");
    }
}
