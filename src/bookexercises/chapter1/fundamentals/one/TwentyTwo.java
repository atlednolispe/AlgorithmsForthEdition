package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Write a version of BinarySearch that uses the recursive rank() given on page
 * 25 and traces the method calls. Each time the recursive method is called, print the
 * argument values lo and hi, indented by the depth of recursion. Hint: Add an argument
 * to the recursive method that keeps track of the depth.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/25
 */
public class TwentyTwo {
    public static int rank(int key, int[] a)
    {  return rank(key, a, 0, a.length - 1);  }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        StdOut.println("lo: " + lo + ", " + "hi: " + hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else                   return mid;
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        return rank(key, a, lo, hi, 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6, 7, 9, 11};
        String stringArray = Arrays.toString(array);
        for(int i = 7; i != 10; ++i)
        {
            int r = rank(i, array);
            StdOut.println("Rank " + i + " in " + stringArray + " = " + r);
        }
    }
}
