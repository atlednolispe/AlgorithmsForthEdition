package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Remove duplicates. Modify the test client in BinarySearch to remove any duplicate
 * keys in the whitelist after the sort.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/30
 */
public class TwentyEight {
    /**
     * Later to find a better solution.
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        int[] uniqueWhitelistTemp = new int[whitelist.length];
        uniqueWhitelistTemp[0] = whitelist[0];
        int j = 1;
        for (int i = 1; i != whitelist.length; ++i)
        {
            if (whitelist[i] != whitelist[i-1])
            {
                uniqueWhitelistTemp[j] = whitelist[i];
                j++;
            }
        }

        int[] uniqueWhitelist = new int[j];
        for (int i = 0; i != j; ++i)
        {
            uniqueWhitelist[i] = uniqueWhitelistTemp[i];
        }

        StdOut.println(Arrays.toString(whitelist));
        StdOut.println(Arrays.toString(uniqueWhitelistTemp));
        StdOut.println(Arrays.toString(uniqueWhitelist));
    }
}
