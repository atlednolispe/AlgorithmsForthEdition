package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.2
 *
 * Give the type and value of each of the following expressions:
 * a. (1 + 2.236)/2
 * b. 1 + 2 + 3 + 4.0
 * c. 4.1 >= 4
 * d. 1 + 2 + "3"
 */
public class Two {
    public static void main(String[] args) {
        double a = (1 + 2.236)/2;
        double b = 1 + 2 + 3 + 4.0;
        boolean c = 4.1 >= 4;
        String d = 1 + 2 + "3";
        StdOut.printf("Type: %s Value: %f\n", new Double(a).getClass(), a);
        StdOut.printf("Type: %s Value: %f\n", new Double(b).getClass(), b);
        StdOut.printf("Type: %s Value: %b\n", new Boolean(c).getClass(), c);
        StdOut.printf("Type: %s Value: %s\n", d.getClass(), d);
    }
}
