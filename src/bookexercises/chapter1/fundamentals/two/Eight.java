package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Suppose that a[] and b[] are each integer arrays consisting of millions of inte-
 * gers. What does the follow code do? Is it reasonably efficient?
 *
 * int[] t = a; a = b; b = t;
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/30
 */
public class Eight {
    public static void main(String[] args) {
        int[] a = new int[1000000];
        int[] b = new int[1000000];
        b[0] = 1;

        // swap a & b
        int[] t = a; a = b; b = t;
        StdOut.println(a[0]);
    }
}
