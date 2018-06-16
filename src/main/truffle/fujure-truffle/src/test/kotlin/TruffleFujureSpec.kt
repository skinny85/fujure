import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.FujureTruffleLanguage.LANG_ID
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class TruffleFujureSpec : SpecnazKotlinJUnit("Fujure on Truffle", {
    val context = Context.create()

    it.should("evaluate code in the default package to 42") {
        val value = context.eval(LANG_ID, "def a = 1")
        assertThat(value.asInt()).isEqualTo(42)
    }

    it.should("evaluate code in a non-default package to 129") {
        val value = context.eval(LANG_ID, """
                package com.example

                def a = 1
            """)
        assertThat(value.asInt()).isEqualTo(129)
    }

    it.shouldThrow<PolyglotException>("when evaluating syntactically incorrect code") {
        context.eval(LANG_ID, "1 + 2")
    }.withoutCause()
})
