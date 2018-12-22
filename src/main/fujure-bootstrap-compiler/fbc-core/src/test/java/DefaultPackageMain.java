/*
 * This does not compile,
 * with a distinct error:
 * "Class'DefaultPackageClass' is in the default package".
 */
//import DefaultPackageClass;

/*
 * This does not compile, error:
 * "Cannot resolve symbol 'ClassDoesNotExist'".
 */
//import ClassDoesNotExist;

/*
 * This also does not compile,
 * same error as above
 * ("Class'DefaultPackageClass' is in the default package").
 */
//import static DefaultPackageClass.m;

public class DefaultPackageMain {
    public static void main(String[] args) {
        /*
         * You can reference a class from the default package
         * in a class also in the default package without an issue.
         */
        DefaultPackageClass.m();
    }
}
