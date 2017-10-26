package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Give the sequence of values of p and q that are computed when Euclid's algorithm
 * is used to compute the greatest common divisor of 105 and 24. Extend the code
 * given on page 4 to develop a program Euclid thats two integers from the command
 * line and computes their greatest common divisor, printing out the two arguments for
 * each call on the recursive method. Use your program to compute the greatest common
 * divisor or 1111111 and 1234567.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/26
 */
public class TwentyFour {
    public static int gcd(int p, int q)
    {
        StdOut.printf("p: %d, q: %d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int gcdResult = gcd(p, q);
        StdOut.printf("The greatest common divisor of %d and %d is %d\n", p, q, gcdResult);
    }
}
