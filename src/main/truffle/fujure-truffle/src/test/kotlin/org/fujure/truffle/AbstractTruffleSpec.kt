package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.FujureTruffleLanguage.Companion.LANG_ID
import org.fujure.truffle.test.PolyglotAssertion
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.graalvm.polyglot.Value
import org.junit.runner.RunWith
import org.specnaz.kotlin.SpecnazKotlin
import org.specnaz.kotlin.junit.SpecnazKotlinJUnitRunner

@RunWith(SpecnazKotlinJUnitRunner::class)
abstract class AbstractTruffleSpec : SpecnazKotlin {
    protected lateinit var context: Context
    protected lateinit var result: Value
    private lateinit var exception: Exception
    protected lateinit var fujureBindings: Value

    fun evalFujure(moduleContents: String) {
        try {
            result = context.eval(LANG_ID, moduleContents)
            exception = Exception()
        } catch (e: PolyglotException) {
            exception = e
        } finally {
            fujureBindings = context.getBindings(LANG_ID)
        }
    }

    fun assertNoException() {
        assertThat(exception)
                .isNotInstanceOf(PolyglotException::class.java)
    }

    fun assertThatPolyglot(): PolyglotAssertion {
        return PolyglotAssertion.assertThatPolyglot(if (exception::class == Exception::class)
            null
        else
            exception)
    }
}
