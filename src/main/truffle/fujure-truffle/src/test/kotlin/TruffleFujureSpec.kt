import org.assertj.core.api.Assertions.assertThat
import org.graalvm.polyglot.Context
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class TruffleFujureSpec : SpecnazKotlinJUnit("Fujure on Truffle", {
    it.should("evaluate some Fujure code") {
        val context = Context.create()
        val value = context.eval("fujure", "1 + 2")
        assertThat(value.asInt()).isEqualTo(37)
    }
})
