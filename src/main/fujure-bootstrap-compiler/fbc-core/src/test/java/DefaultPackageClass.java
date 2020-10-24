import java.util.List;

/**
 * An example class in the default package.
 * Used for testing import and reference semantics in Java.
 */
public class DefaultPackageClass {
    public static int m() {
        return f;
    }

    static int f = m();

//    static String<Integer> r; // Type 'java.lang.String' does not have type parameters
//    static List<Integer, String> l; // Wrong number of type arguments: 2, required 1
}
