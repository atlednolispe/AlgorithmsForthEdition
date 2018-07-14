package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;

/**
 * What does the following code fragment print when N is 50? Give a high-level
 * description of what it does when presented with a positive integer N.
 *
 * Stack<Integer> stack = new Stack<Integer>();
 * while (N > 0)
 * {
 *     stack.push(N % 2);
 *     N = N / 2;
 * }
 * for (int d : stack) StdOut.print(d);
 * StdOut.println();
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/14
 */
public class Five {
    /**
     * binary
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        int N = 50;
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2; }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
