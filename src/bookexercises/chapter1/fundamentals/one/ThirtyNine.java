package bookexercises.chapter1.fundamentals.one;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Random matches. Write a BinarySearch client that takes an int value T as
 * command-line argument and runs T trials of the following experiment for N = 10^3, 10^4,
 * 10^5, and 10^6: generate two arrays of N randomly generated positive six-digit int values,
 * and find the number of values that appear in both arrays. Print a table giving the average
 * value of this quantity over the T trials for each value of N.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtyNine {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
            {
                hi = mid - 1;
            }
            else if (key > a[mid])
            {
                lo = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int[] generateArray(int N)
    {
        int[] array = new int[N];
        for (int i = 0; i != N; ++i)
        {
            array[i] = StdRandom.uniform(100000, 1000000);
        }
        Arrays.sort(array);
        return array;
    }

    public static int getCommonNumberCount(int[] array1, int[] array2)
    {
        int count = 0;
        for (int i = 0; i != array1.length; ++i)
        {
            if (rank(array1[i], array2) != -1)
            {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int T = Integer.parseInt(args[0]);
        int[] NArray = {1000, 10000, 100000, 1000000};

        for (int n: NArray)
        {
            double sum = 0;
            for (int i = 0; i != T; ++i)
            {
                int[] array1 = generateArray(n);
                int[] array2 = generateArray(n);
                sum += getCommonNumberCount(array1, array2);
            }
            StdOut.println("" + n + ": " + sum / T);
        }
    }
}
