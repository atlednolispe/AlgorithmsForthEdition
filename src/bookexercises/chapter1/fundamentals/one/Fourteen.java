package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * Return the largest int not larger than the base-2 logarithm of N.
 */
public class Fourteen {
    public static int lg(int N) {
//        add Exception later
//        if (N < 0)
//            return 0;
        int res = 0;
        while ((N /= 2) != 0) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i != 11; ++i)
            StdOut.printf("log2(%d) = %d\n", i, Fourteen.lg(i));
    }
}
