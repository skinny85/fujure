import org.assertj.core.api.Assertions.assertThat
import org.graalvm.polyglot.Context
import org.specnaz.kotlin.junit.SpecnazKotlinJUnit

class TruffleJsKotlinSpec : SpecnazKotlinJUnit("Using Truffle Context", {
    it.should("successfully evaluate some JS code") {
        val context = Context.create();
        val value = context.eval("js", "(function() { return 1 + 2; })();");
        assertThat(value.asInt()).isEqualTo(3);
    }
})
