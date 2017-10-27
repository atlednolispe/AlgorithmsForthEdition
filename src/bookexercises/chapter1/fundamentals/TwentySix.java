package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Sorting three numbers. Suppose that the variables a, b, c, and t are all of the
 * same numeric primitive type. Show that the following code puts a, b, and c in ascending
 * order.
 * if (a > b) { t = a; a = b; b = t; }
 * if (a > c) { t = a; a = c; c = t; }
 * if (a > b) { t = b; b = c; c = t; }
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/27
 */
public class TwentySix {
    public static int[] sort(int a, int b, int c) {
        int t;
        // step1: make a < b
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        // step2: make a < c & a = min{a, b, c}
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        // step3: make b < c, then a < b < c, done.
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        return new int[]{a, b, c};
    }

    public static void main(String[] args) {
        int a = 17;
        int b = 8;
        int c = 9;
        StdOut.println(Arrays.toString(new int[]{a, b, c}));
        int[] ascendRes = sort(a, b, c);
        StdOut.println(Arrays.toString(ascendRes));
    }
}
