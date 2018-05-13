import org.graalvm.polyglot.Context;
import org.specnaz.junit.SpecnazJUnit;

public class MainSpec extends SpecnazJUnit {{
    describes("Using Truffle Context", it -> {
        it.shouldThrow(IllegalStateException.class, "when trying to evaluate some js code", () -> {
            Context context = Context.create();
            context.eval("js", "1 + 2");
        });
    });
}}
