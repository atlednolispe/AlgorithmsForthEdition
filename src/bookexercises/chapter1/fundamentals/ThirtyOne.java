package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Random connections. Write a program that takes as command-line arguments
 * an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size
 * .05 on the circumference of a circle, and then, with probability p for each pair of points,
 * draws a gray line connecting them.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtyOne {
    public static void drawCircle(double x, double y, double r)
    {
        StdDraw.setXscale(x - r - 1, x + r + 1);
        StdDraw.setYscale(y - r -1, y + r + 1);
        StdDraw.circle(x, y, r);
    }

    public static double[][] getPoints(double x, double y, double r, int n)
    {
        double[][] points = new double[n][2];
        double theta;
        for (int i = 0; i != n; ++i)
        {
            theta = 2 * Math.PI / n * i;
            points[i][0] = x + r * Math.cos(theta);
            points[i][1] = y + r * Math.sin(theta);
        }
        return points;
    }

    public static void drawPoints(double[][] points)
    {
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i != points.length; ++i)
        {
            StdDraw.point(points[i][0], points[i][1]);
        }
        StdDraw.setPenRadius();
    }

    public static void connectTwoPoint(double[] point1, double[] point2, double p)
    {
        double r = Math.random();

        if (p > r)
        {
            StdDraw.line(point1[0], point1[1], point2[0], point2[1]);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        double circleX = 3, circleY = 3, circleR = 2;

        drawCircle(circleX, circleY, circleR);

        double[][] points = getPoints(circleX, circleY, circleR, N);

        drawPoints(points);

        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i != N; ++i)
        {
            for (int j = i+1; j != N; ++j)
            {
                connectTwoPoint(points[i], points[j], p);
            }
        }
    }
}
