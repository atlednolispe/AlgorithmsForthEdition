package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * Instrument BinarySearch(page47) to use a Counter to count the total number
 * of keys examined during all searches and then print the total after all searches are com-
 * plete. Hint : Create a Counter in main() and pass it as an argument to rank().
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/30
 */
public class Nine {
    public static int indexOf(int[] a, int key, Counter c) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            c.increment();

            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else
            {
                StdOut.println("The total number of keys examined during all searches is " + c.tally());
                return mid;
            }
        }
        StdOut.println("The total number of keys examined during all searches is " + c.tally());
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{ 1, 9, 8, 3, 7, 2 };
        Counter c = new Counter("Examined");

        // sort the array
        Arrays.sort(whitelist);

        indexOf(whitelist, 7, c);
    }
}
