package a.b.c;

import java.util.function.Function;

/**
 * A class used in {@link a.Main} to test importing classes
 * with the same name.
 *
 * @see a.b.Y
 */
public class Y {
//    private static int j = i; // this is not allowed: "Illegal forward reference"

    // don't need an explicit import to use a class from the java.lang package
    public static final int i = Integer.MAX_VALUE - 1;

    // this works fine
    public static boolean odd(int n) { return n <= 0 ? false : even(n - 1); }
    public static boolean even(int n) { return n <= 0 ? true : odd(n - 1); }

    // this doesn't work either!
//    private static final Function<Integer, Boolean> lambdaOdd = (Integer n) -> n <= 0 ? false : lambdaEven.apply(n - 1);
//    private static final Function<Integer, Boolean> lambdaEven = (Integer n) -> n <= 0 ? true : lambdaOdd.apply(n - 1);
}
