/**
 * An example class in the default package.
 * Used for testing import and reference semantics in Java.
 */
public class DefaultPackageClass {
    public static int m() {
        return f;
    }

    static int f = m();
}
