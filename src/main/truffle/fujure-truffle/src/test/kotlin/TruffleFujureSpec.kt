import org.assertj.core.api.Assertions.assertThat
import org.fujure.truffle.FujureTruffleLanguage.LANG_ID
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.PolyglotException
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class TruffleFujureSpec : SpecnazKotlinJUnit("Fujure on Truffle", {
    val context = Context.create()

    it.should("always evaluate correct code to 37") {
        val value = context.eval(LANG_ID, "def a = 1")
        assertThat(value.asInt()).isEqualTo(37)
    }

    it.shouldThrow<PolyglotException>("when evaluating syntactically incorrect code") {
        context.eval(LANG_ID, "1 + 2")
    }
})
