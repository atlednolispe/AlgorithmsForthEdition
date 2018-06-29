package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Dice simulation. The following code computes the exact probability distribu-
 * tion for the sum of two dice:
 *
 * int SIDES = 6;
 * double[] dist = new double[2*SIDES+1];
 * for (int i = 1; i <= SIDES; i++)
 *     for (int j = 1; j <= SIDES; j++)
 *         dist[i+j] += 1.0;
 *
 * for (int k = 2; k <= 2*SIDES; k++)
 *     dist[k] /= 36.0;
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtyFive {
    public static double[] getDistribution()
    {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
        {
            for (int j = 1; j <= SIDES; j++)
            {
                dist[i+j] += 1.0;
            }
        }

        for (int k = 2; k <= 2*SIDES; k++)
        {
            dist[k] /= 36.0;
        }

        return dist;
    }

    public static void showDice(double[] dist)
    {
        for (int k = 2; k != dist.length; k++)
        {
            StdOut.printf("%-2d : %.4f\n", k, dist[k]);
        }
    }

    public static double[] simulation(int N)
    {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        int r1, r2;

        for (int i = 0; i != N; ++i)
        {
            r1 = StdRandom.uniform(1, 7);
            r2 = StdRandom.uniform(1, 7);

            dist[r1 + r2] += 1;
        }

        for (int k = 2; k <= 2*SIDES; k++)
        {
            dist[k] /= N;
        }

        return dist;
    }

    public static boolean pass(double[] dist1, double[] dist2)
    {
        for (int k = 2; k != dist1.length; k++)
        {
            int diff = (int)(dist1[k]*1000) - (int)(dist2[k]*1000);
            if (diff != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double[] theoryDist = getDistribution();
        showDice(theoryDist);
        StdOut.println();

        int N = 10;
        double[] simulationDist = simulation(N);
        while (!pass(theoryDist, simulationDist))
        {
            N *= 10;
            simulationDist = simulation(N);
        }

        StdOut.println("Passed N is " + N);
        showDice(simulationDist);
        StdOut.println();
    }
}
