package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * What does the program print?
 * Fibonacci numbers
 */
public class Six {
    public static void fibonacci() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void main(String[] args) {
        Six.fibonacci();
    }
}
