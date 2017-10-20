package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Give the value of exR1(6).
 */
public class Sixteen {
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    /**
     * 1. e6
     * 2. e3 + 6 + e4 + 6
     * 3. e0 + 3 + e1 + 3 | 6 | e1 + 4 + e2 + 4 | 6
     * 4. "" + 3 + "11" + 36 + "11" + 4 + 22 + 46
     * 5. 311361142246
     */
    public static void main(String[] args) {
        StdOut.println(exR1(6));
    }
}
