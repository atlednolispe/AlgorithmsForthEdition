package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Add to the BinarySearch test client the ability to respond to a second
 * argument: + to print numbers from standard input that are not in the whitelist,
 * - to print numbers that are in the whitelist.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/26
 */
public class TwentyThree {
    /**
     *
     * @param option + to print numbers are not in the whitelist, - are in
     * @param args standard input
     */
    public static void whitelist (String option, String[] args) {
        int[] whitelist = In.readInts(args[0]);
        boolean inWhitelist = true;
        if (option.equals("+")) {
            inWhitelist = false;
        }
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (inWhitelist == false && BinarySearch.rank(key, whitelist) < 0) {
                StdOut.println(key);
            } else if (inWhitelist == true && BinarySearch.rank(key, whitelist) >= 0) {
                StdOut.println(key);
            }
        }
    }

    /**
     * Just can read StdIn for one time.
     * Add StdOut.println(Arrays.toString(whitelist)); before boolean inWhitelist = true;
     * and StdOut.println(Arrays.toString(StdIn.readAllInts())); before while (!StdIn.isEmpty())
     * to test.
     */
    public static void main(String[] args) {
//        StdOut.println("----------not in the whitelist----------");
//        TwentyThree.whitelist("+", args);
        StdOut.println("------------in the whitelist------------");
        TwentyThree.whitelist("-", args);
    }
}
