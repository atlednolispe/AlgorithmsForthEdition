package bookexercises.chapter1.fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

/**
 * Histogram. Suppose that the standard input stream is a sequence of double
 * values. Write a program that takes an integer N and two double values l and r from the
 * command line and uses StdDraw to plot a histogram of the count of the numbers in the
 * standard input stream that fall in each of the N intervals defined by dividing (l , r) into
 * N equal-sized intervals.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtyTwo {
    public static void drawHistogram(double l, double r, int[] countArray)
    {
        double interval = (r - l) / countArray.length;
        // the max count of the histogram
        int max = Arrays.stream(countArray).max().getAsInt();

        StdDraw.setXscale(l - 1, r + 1);
        StdDraw.setYscale(0, max + 1);
        for (int i = 0; i != countArray.length; ++i)
        {
            double rw = interval / 2;
            double x = l + interval * i + rw;
            double y = countArray[i] / 2.0;
            double rh = y;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        int[] countArray = new int[N];
        int index;
        double interval = (r - l) / countArray.length;

        while (!StdIn.isEmpty())
        {
            double value = StdIn.readDouble();
            index = (int)((value - l) / interval);
            countArray[index]++;
        }

        drawHistogram(l, r, countArray);
    }
}
