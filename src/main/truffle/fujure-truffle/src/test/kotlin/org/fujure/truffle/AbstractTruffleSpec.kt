package org.fujure.truffle

import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.FujureTruffleLanguage.Companion.LANG_ID
import org.fujure.truffle.test.PolyglotAssertion
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.Value
import org.junit.runner.RunWith
import org.specnaz.kotlin.SpecnazKotlin
import org.specnaz.kotlin.junit.SpecnazKotlinJUnitRunner
import java.util.regex.Pattern

@RunWith(SpecnazKotlinJUnitRunner::class)
abstract class AbstractTruffleSpec : SpecnazKotlin {
    protected lateinit var context: Context
    protected lateinit var result: Value
    private lateinit var exception: Exception
    protected lateinit var fujureBindings: Value

    fun evalFujure(moduleContents: String, fileName: String? = null) {
        try {
            result = if (fileName == null) {
                context.eval(LANG_ID, moduleContents)
            } else {
                val source = Source.newBuilder(LANG_ID, moduleContents, fileName).build()
                context.eval(source)
            }
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

    fun Value.userDefinedMemberKeys(): Set<String> {
        val ret = mutableSetOf<String>()
        for (key in this.memberKeys) {
            if (!keyIsBuiltIn(key))
                ret.add(key)
        }
        return ret
    }

    private fun keyIsBuiltIn(key: String): Boolean {
        return BUILT_IN_KEY_REGEX.matcher(key).matches()
    }

    private companion object {
        val BUILT_IN_KEY_REGEX: Pattern = Pattern.compile("""^fujure\..+$""")
    }
}
