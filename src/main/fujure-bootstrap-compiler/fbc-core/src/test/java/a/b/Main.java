package a.b;

// uncommenting this import would make the below code not compile
// (the import has higher priority than the class in the same package)
//import java.lang.Integer;

/**
 * A class with the same name as {@link a.Main},
 * used to test what happens when it's imported in that class' file.
 */
public class Main {
    boolean b = Integer.MAX_VALUE; // shadows java.lang.Integer
    int i = java.lang.Integer.MAX_VALUE;
}
