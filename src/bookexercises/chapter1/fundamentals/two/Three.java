package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.*;

/**
 * Write an Interval2D client that takes command-line arguments N, min, and max
 * and generates N random 2D intervals whose width and height are uniformly distributed
 * between min and max in the unit square. Draw them on StdDraw and print the number
 * of pairs of intervals that intersect and the number of intervals that are contained in one
 * another.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/29
 */
public class Three {
    public static double[] generateSortedTwoEndpoints(double min, double max)
    {
        double rand1 = StdRandom.uniform(min, max);
        double rand2 = StdRandom.uniform(min, max);

        if (rand1 < rand2)
        {
            return new double[] {rand1, rand2};
        }
        else
        {
            return new double[] {rand2, rand1};
        }
    }

    public static Interval2D[] generateInterval2DArray(int N, double min, double max) {
        Interval2D[] interval2DArray = new Interval2D[N];

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        Interval2D interval2D;
        for (int i = 0; i != N; ++i)
        {
            double[] endPoints1 = generateSortedTwoEndpoints(min, max);
            double[] endPoints2 = generateSortedTwoEndpoints(min, max);

            interval2D = new Interval2D(
                    new Interval1D(endPoints1[0], endPoints1[1]),
                    new Interval1D(endPoints2[0], endPoints2[1])
            );
            interval2DArray[i] = interval2D;
            interval2D.draw();
        }

        return interval2DArray;
    }

    public static String[] getInterval2DFourEndpoints(Interval2D interval2D) {
        // return interval2D's coord [xmin, xmax, ymin, ymax] in String
        String[] interval = interval2D.toString().split(" x ");
        String intervalX = interval[0];
        String intervalY = interval[1];

        String[] intervalXTwoParts = intervalX.split(", ");
        String intervalXLeftPart = intervalXTwoParts[0];
        String intervalXLeft = intervalXLeftPart.substring(1, intervalXLeftPart.length());
        String intervalXRightPart = intervalXTwoParts[1];
        String intervalXRight = intervalXRightPart.substring(0, intervalXRightPart.length()-1);

        String[] intervalYTwoParts = intervalY.split(", ");
        String intervalYLeftPart = intervalYTwoParts[0];
        String intervalYLeft = intervalYLeftPart.substring(1, intervalYLeftPart.length());
        String intervalYRightPart = intervalYTwoParts[1];
        String intervalYRight = intervalYRightPart.substring(0, intervalYRightPart.length()-1);

        return new String[] {intervalXLeft, intervalXRight, intervalYLeft, intervalYRight};
    }

    public static boolean containedJudge(Interval2D i, Interval2D j) {
        // judge if interval2D i contained in j
        // later can be dimensionality reduction to 1D -> judge 1D if contained
        String[] Interval2DIFourEndpoints = getInterval2DFourEndpoints(i);
        String[] Interval2DJFourEndpoints = getInterval2DFourEndpoints(j);

        if (Interval2DIFourEndpoints[0].compareTo(Interval2DJFourEndpoints[0]) >= 0)
        {
            if (Interval2DIFourEndpoints[1].compareTo(Interval2DJFourEndpoints[1]) <= 0)
            {
                if (Interval2DIFourEndpoints[2].compareTo(Interval2DJFourEndpoints[2]) >= 0)
                {
                    if (Interval2DIFourEndpoints[3].compareTo(Interval2DJFourEndpoints[3]) <= 0)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean containedInOneAnother(Interval2D i, Interval2D j) {
        if (containedJudge(i, j) || containedJudge(j, i))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        int intersect = 0, contained = 0;
        Interval2D[] interval2DArray = generateInterval2DArray(N, min, max);
        for (int i = 0; i != N; ++i)
        {
            for (int j = i+1; j != N; ++j)
            {
                if (interval2DArray[i].intersects(interval2DArray[j]))
                {
                    intersect++;

                    if (containedInOneAnother(interval2DArray[i], interval2DArray[j]))
                    {
                        contained++;
                    }
                }

            }
        }

        StdOut.println("The number of pairs of intervals that intersect is: " + intersect);
        StdOut.println("The number of intervals that are contained in one another is: " + contained);
    }
}
