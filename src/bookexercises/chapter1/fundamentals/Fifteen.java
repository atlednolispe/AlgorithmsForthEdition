package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Fifteen {
    /**
     * Count the number of times the integer i between 0 and (M - 1) appeared in the array.
     *
     * @param array
     * @param M
     * @return int[]: ith entry is the number of times the integer i appeared in the para array.
     */
    public static int[] histogram(int[] array, int M) {
        int[] ret = new int[M];
        for (int i = 0; i != array.length; ++i) {
            if (array[i] >= 0 && array[i] < M)
                ret[array[i]]++;
        }
        return ret;
    }

    public static void main(String[] args) {
        StdOut.println(Arrays.toString(Fifteen.histogram(new int[]{1, 2, 3, 3, 4, 5}, 4)));
        StdOut.println(Arrays.toString(Fifteen.histogram(new int[]{1, 2, 3, 3, 4, 5}, 6)));
    }
}
