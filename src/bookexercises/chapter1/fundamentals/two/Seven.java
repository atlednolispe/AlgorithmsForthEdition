package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * What does the following recursive function return?
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/30
 */
public class Seven {
    public static String mystery(String s)
    {
        // reverse s
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        StdOut.println(mystery("0123456789"));
    }
}
