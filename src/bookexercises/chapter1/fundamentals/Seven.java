package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Give the value printed by each of the following code fragments.
 */
public class Seven {
    /**
     * sqrt
     */
    public static void f1() {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void f2() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void f3() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void main(String[] args) {
        Seven.f1();
        Seven.f2();
        Seven.f3();
    }
}
