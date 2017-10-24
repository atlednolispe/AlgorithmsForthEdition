package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Run the following program F(N) on your computer:
 * What is the largest value of N for which this program takes less 1 hour to compute the
 * value of F(N)? Develop a better implementation of F(N) that saves computed values in
 * an array.
 * After 1 hour print: 56 225851433717
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/24
 */
public class Nineteen {
    /**
     * Fibonacci
     */
    public static long F(int N)
    {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F(N-1) + F(N-2);
    }

    /**
     * A better implementation of F(N) that saves computed values in
     * an array.
     */
    public static long[] F1(int N)
    {
        if (N == 0) {
            return new long[]{0};
        }
        if (N == 1) {
            return new long[]{1, 0};
        }
        long[] fibonacci = new long[N+1];
        fibonacci[1] = 1;
        for (int i = 2; i < N+1; ++i)
        {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        for (int N = 0; N < 50; N++) {
            StdOut.println(Arrays.toString(F1(N)));
        }
    }
}

