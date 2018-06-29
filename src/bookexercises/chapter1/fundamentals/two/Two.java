package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write an Interval1D client that takes an int value N as command-line argument,
 * reads N intervals (each defined by a pair of double values) from standard input,
 * and prints all pairs that intersect.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/29
 */
public class Two {
    public static void showIntersects(Interval1D[] interval1DArray) {
        int arrayLength = interval1DArray.length;
        for (int i = 0; i != arrayLength ; ++i)
        {
            for (int j = i+1; j != arrayLength; ++j)
            {
                if (interval1DArray[i].intersects(interval1DArray[j]))
                {
                    StdOut.println(interval1DArray[i] + " ∩ " + interval1DArray[j] + " ≠ ∅");
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Interval1D[] interval1DArray = new Interval1D[N];
        for (int i = 0; i != N; ++i)
        {
            // 区间需要左小右大
            interval1DArray[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }

        showIntersects(interval1DArray);
    }
}
