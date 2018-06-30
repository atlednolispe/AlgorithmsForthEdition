package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * What does the following code fragment print?
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/30
 */
public class Four {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
