import org.antlr.v4.runtime.ANTLRInputStream;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.FujureLexer;
import org.graalvm.polyglot.Context;

public class Main {
    public static void main(String[] args) {
        Context context = Context.create();
        new FujureLexer(new ANTLRInputStream(""));
    }
}
