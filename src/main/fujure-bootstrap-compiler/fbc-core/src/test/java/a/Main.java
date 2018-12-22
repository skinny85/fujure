package a;

/*
 * There is no way to refer to a class in the default package
 * from a class in a non-default package.
 * Importing fails with the familiar
 * "Class 'DefaultPackageClass' is in the default package" error,
 * and simply using it by name causes an "unresolved symbol" error.
 */
//import DefaultPackageClass;
//import static DefaultPackageClass.m;

/*
 * Importing yourself compiles, but causes a warning
 * ("unused import statement").
 */
//import a.Main;

/*
 * Same with a static import
 * ("unused import statement").
 */
//import static a.Main.main;

/*
 * Importing the same name as the class makes the class definition not compile!
 * Plus, you get an "unused import statement" warning.
 */
//import a.b.Main;

/*
 * Importing a class in the same package is allowed,
 * but causes a warning
 * ("unused import statement").
 */
//import a.X;

/*
 * A static import for a method of a class in the same package does work.
 */
import static a.X.m;

/*
 * Importing a class named the same in 2 different packages
 * results in an error for the second one
 * ("'a.b.Y' is already defined in a single-type import")!
 */
//import a.b.Y;
//import a.b.c.Y;

/*
 * An import can be shadowed by a local variable
 * with the same name as the imported class
 * when calling static methods on the imported class,
 * but the type import itself is still valid
 * (you can still refer to the `Z` type in the class,
 * and it works as expected).
 */
import a.b.Z;

public class Main {
    /**
     * Field that shadows the import for `a.b.Z`.
     */
    private static Integer Z;

    public static void main(String[] args) throws Exception {
        // referenced without `Main` works
        main(args);

        // referenced with `Main.` also works
        Main.main(args);

        // no need to import (same package),
        // but qualifying with the class name
        // still works, even with the static import
        X.m();

        // static import works
        m();

        /*
         * Uncomment this variable to see that shadowing works on
         * local variables as well.
         */
//        Integer Z = 3;
        Z.compareTo(5);

        // but the import is still valid -
        // this compiles without issues
        Z zInstance = Z.class.newInstance();
    }
}
