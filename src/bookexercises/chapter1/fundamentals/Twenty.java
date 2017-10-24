package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Write a recursive static method that computes the value of ln(N!), ln(a*b) = ln(a) + ln(b)
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/24
 */
public class Twenty {
    public static double lnFactorialN(int N)
    {
        if (N < 1) {
            return -1;
        }
        if (N == 1) {
            return Math.log(1);
        }
        return lnFactorialN(N-1) + Math.log(N);
    }
    public static void main(String[] args) {
        for (int i = 1; i != 20; ++i)
        {
            StdOut.printf("ln(%3d!) = %6.2f\n", i, lnFactorialN(i));
        }
    }
}
