import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.specnaz.junit.SpecnazJUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class TruffleJsSpec extends SpecnazJUnit {{
    describes("Using Truffle Context", it -> {
        it.should("successfully evaluate some JS code", () -> {
            Context context = Context.create();
            Value value = context.eval("js", "1 + 2");
            assertThat(value.asInt()).isEqualTo(3);
        });
    });
}}
