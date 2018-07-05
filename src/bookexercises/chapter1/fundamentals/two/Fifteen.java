package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * File input. Develop a possible implementation of the static readInts() meth-
 * od from In (which we use for various test clients, such as binary search on page 47) that
 * is based on the split() method in String.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/5
 */
public class Fifteen {
    public static int[] readInts(String s) {
        String[] stringIntArray = s.split("\\s+");

        int[] ints = new int[stringIntArray.length];
        for (int i = 0; i != ints.length; ++i)
        {
            ints[i] = Integer.parseInt(stringIntArray[i]);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = readInts("1 2  3");
        for (int i = 0; i != ints.length; ++i)
        {
            StdOut.println(ints[i]);
        }
    }
}
