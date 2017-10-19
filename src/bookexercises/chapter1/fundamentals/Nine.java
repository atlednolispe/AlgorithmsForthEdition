package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Puts the binary representation of a positive integer N into a String s
 */
public class Nine {
    /**
     *
     * @author atlednolispe
     */
    public static String convert1(int N) {
        String res = "";
        while (N > 0)
        {
            res = N % 2 + res;
            N /= 2;
        }
        return res;
    }

    public static String convert2(int N) {
        return Integer.toBinaryString(N);
    }

    public static String convert3(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        return s;
    }

    public static void main(String[] args) {
        int N = 10;
        StdOut.println(convert1(N));
        StdOut.println(convert2(N));
        StdOut.println(convert3(N));
    }
}
