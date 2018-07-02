package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Develop a class VisualCounter that allows both increment and decrement
 * operations. Take two arguments N and max in the constructor, where N specifies the
 * maximum number of operations and max specifies the maximum absolute value for
 * the counter. As a side effect, create a plot showing the value of the counter each time its
 * tally changes.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/1
 */
public class Ten {
    private final int OPERATORUPPERLIMIT;
    private final int ABSUPPERLIMIT;
    private int count = 0;
    private int value = 0;

    public Ten(int N, int max) {
        OPERATORUPPERLIMIT = N;
        ABSUPPERLIMIT = max;

        StdDraw.setXscale(-1, OPERATORUPPERLIMIT+1);
        StdDraw.setYscale(-ABSUPPERLIMIT-1, ABSUPPERLIMIT+1);
        StdDraw.setPenRadius(0.01);

        StdDraw.point(0, 0);
    }

    public void operator(String operator) {
        // if value is out of bound, draw a horizontal line
        int[] parasLine;

        if (count < OPERATORUPPERLIMIT)
        {
            count++;

            if ("increment".equals(operator))
            {
                value++;
            }
            else
            {
                value--;
            }

            if (Math.abs(value) <= ABSUPPERLIMIT)
            {
                if ("increment".equals(operator))
                {
                    parasLine = new int[]{count-1, value-1, count, value};
                }
                else
                {
                    parasLine = new int[]{count-1, value+1, count, value};
                }
            }
            else
            {
                if ("increment".equals(operator))
                {
                    // recover the value
                    value--;
                    parasLine = new int[]{count-1, value, count, value};
                }
                else
                {
                    value++;
                    parasLine = new int[]{count-1, value, count, value};
                }
                StdOut.println("Value out of bound!!!");
            }

            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenRadius(0.001);
            StdDraw.line(parasLine[0], parasLine[1], parasLine[2], parasLine[3]);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            StdDraw.point(count, value);
        }
        else
        {
            StdOut.println("Count touch the ceiling!");
        }


    }

    public void increment() {
        operator("increment");
    }

    public void decrement() {
        operator("decrement");
    }

    public static void main(String[] args) {
        int N = 50;
        int max = 5;

        Ten t = new Ten(N, max);

        for (int i = 0; i != N+1; ++i)
        {
            if (StdRandom.uniform() > 0.5)
            {
                t.increment();
            }
            else
            {
                t.decrement();
            }
        }
    }
}
