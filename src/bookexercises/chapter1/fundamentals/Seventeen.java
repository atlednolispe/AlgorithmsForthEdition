package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

public class Seventeen {
    /**
     * Criticize exR2
     * 1. e6
     * 2. s = e3 + 6 + e4 + 6
     * 3. s = e0 + 3 + e1 + 3 | 6 | e1 + 4 + e2 + 4 | 6
     * 4. s = e-3 + 0 + e-2 + 0 + 3 + e-2 + 1 + e-1 + 1 + 3 + ...
     * 5. java.lang.StackOverflowError
     *
     * ERROR: never stop
     *
     * RECURSION:
     * 1. base case - include a conditional statement as the first statement that has a return
     * 2. address subproblems that recursive calls converge to the base case
     * 3. shouldn't address subproblems that overlap
     */
    public static String exR2(int n)
    {
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if (n <= 0) return "";
        return s;
    }

    public static void main(String[] args) {
//        java.lang.StackOverflowError
//        StdOut.println(Seventeen.exR2(6));
    }
}
