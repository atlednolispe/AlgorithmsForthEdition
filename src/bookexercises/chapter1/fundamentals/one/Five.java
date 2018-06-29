package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

public class Five {
    /**
     *
     * @param x
     * @param y
     * @return true if the double para x & y are both between [0,1] or false.
     */
    public static boolean bothZeroToOne(double x, double y) {
        if ( x >= 0 && x <= 1)
        {
            if ( y >= 0 && y <= 1)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        StdOut.println(Five.bothZeroToOne(1,1));
        StdOut.println(Five.bothZeroToOne(0,0));
        StdOut.println(Five.bothZeroToOne(1,1.8));
    }
}
