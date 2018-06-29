package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * Array exercise. Write a code fragment that creates an M-by-N boolean array
 * a[][] such that a[i][j] is true if i and j are relatively prime(have no common
 * factors), and false otherwise.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/3/31
 */
public class Thirty {
    public static int gcd(int p, int q)
    {
        if (q == 0)
        {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static boolean relativelyPrimeOrNot(int i, int j)
    {
        int g = gcd(i, j);
        if (g == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        int M = 8, N = 8;
        StdOut.print("\t");
        for (int i = 2; i != N + 1; ++i)
        {
            StdOut.print(i + "     \t");
        }
        StdOut.println();
        for (int i = 2; i != M + 1; ++i)
        {
            StdOut.print(i+ "\t");
            for (int j = 2; j != N + 1; ++j)
            {
                if (relativelyPrimeOrNot(i, j))
                {
                    StdOut.print("true\t");
                }
                else
                {
                    StdOut.print("false\t");
                }

            }
            StdOut.println();
        }
    }
}
