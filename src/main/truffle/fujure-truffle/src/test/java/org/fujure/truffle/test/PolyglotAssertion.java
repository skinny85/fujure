package org.fujure.truffle.test;

import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.graalvm.polyglot.PolyglotException;

public final class PolyglotAssertion extends
        AbstractThrowableAssert<PolyglotAssertion, PolyglotException> {
    public static PolyglotAssertion assertThatPolyglot(Throwable throwable) {
        Assertions.assertThat(throwable)
                .withFailMessage("Expected a PolyglotException to have been thrown, but no Exception was thrown")
                .isNotNull();
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
            failWithMessage("Expected the PolyglotException to not be a syntax error, but it was");

        return this;
    }

    public PolyglotAssertion isGuestSyntaxError() {
        isGuestException();
        isNotAnInternalError();
        if (!actual.isSyntaxError())
            failWithMessage("Expected the PolyglotException to be a syntax error, but it was not");

        return this;
    }

    public AbstractCharSequenceAssert<?, String> message() {
        return Assertions.assertThat(actual.getMessage());
    }

    private void isGuestException() {
        if (!actual.isGuestException())
            failWithMessage("Expected the PolyglotException to be a guest exception, but it was not");
    }

    private void isNotAnInternalError() {
        if (actual.isInternalError())
            failWithMessage("Expected the PolyglotException to not be an internal error, but it was");
    }
}
