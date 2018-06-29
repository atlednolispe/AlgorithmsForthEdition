package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square,
 * and computes the distance separating the closest pair of points.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/29
 */
public class One {
    public static Point2D[] generatePoint2DArray(int N) {
        Point2D[] point2DArray = new Point2D[N];

        StdDraw.setPenRadius(0.01);

        for (int i = 0; i != N; ++i)
        {
            point2DArray[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            point2DArray[i].draw();
        }

        return point2DArray;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] point2DArray = generatePoint2DArray(N);

        double minDistance = Math.sqrt(2);
        int index0 = 0, index1 = 1;

        for (int i = 0; i != N; ++i)
        {
            for (int j = i+1; j != N; ++j)
            {
                double distance = point2DArray[i].distanceTo(point2DArray[j]);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    index0 = i;
                    index1 = j;
                }
            }
        }

        // draw the closest pair of points in green
        StdDraw.setPenColor(StdDraw.GREEN);
        point2DArray[index0].draw();
        point2DArray[index1].draw();

        StdOut.println("The distance separating the closest pair of points is: ");
        StdOut.println(point2DArray[index0]);
        StdOut.println(point2DArray[index1]);
        StdOut.println("Distance is " + minDistance + ".");
    }
}
