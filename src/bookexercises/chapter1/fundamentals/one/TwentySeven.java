package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * Binomial distribution. Estimate the number of recursive calls that would be
 * used by the code
 *     public static double binomial(int N, int k, double p)
 *     {
 *         if (N == 0 && k == 0) return 1.0;
 *         else if (N < 0 || k < 0) return 0.0;
 *         return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
 *     }
 * to compute binomial(100, 50). Develop a better implementation that is based on
 * saving computed values in an array.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/27
 */
public class TwentySeven {
    public int count;

    public static double binomial(int N, int k, double p)
    {
        if (N == 0 && k == 0) return 1.0;
        else if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    /**
     * C(N,k)=C(N-1,k)+C(N-1,k-1)
     * C(N,k)*p^k*(1-p)^(N-k) = (1-p)*C(N-1,k)*p^k*(1-p)^(N-1-k)+p*C(N-1,k-1)*p^(k-1)*(1-p)^(N-k)
     *
     * The number of recursive calls to compute binomial(100, 50): ???(Have Not Done!)
     *         C(2, 0)-1
     *       /            \
     *     C(1, 0)-1 + C(1, -1)-1
     *     /       \
     * C(0, -1)-1 + C(0, 0)-1
     *
     * Recursive calls of C(2, 0) = 5
     */
    public double binomialCount(int N, int k, double p)
    {
        this.count++;
        if (N == 0 && k == 0) return 1.0;
        else if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomialCount(N-1, k, p) + p*binomialCount(N-1, k-1, p);
    }

    /**
     *
     * @param N N > 0
     * @param k k <= N
     * @return C(N, k)
     */
    public static int binomial(int N, int k)
    {
        int[][] binomialArray = new int[N+1][N+1];
        binomialArray[0][0] = 1;
        binomialArray[1][0] = 1;
        binomialArray[1][1] = 1;
        for (int row = 2; row != N+1; ++row)
        {
            binomialArray[row][0] = 1;
        }
        for (int row = 2; row != N+1; ++row)
        {
            for (int column = 1; column != k+1; ++column)
            {
                binomialArray[row][column] = binomialArray[row-1][column-1] + binomialArray[row-1][column];
                if(row == N && column == k)
                {
                    break;
                }
            }
        }
        return binomialArray[N][k];
    }

    public static void main(String[] args) {
        for (int i = 0; i != 5; i++)
        {
            for (int j = 0; j!= i+1; j++)
            {
                TwentySeven t = new TwentySeven();
                double bTenTwo = t.binomialCount(i, j, 0.5);
                StdOut.printf("Recursive calls of C(%d, %d) = %d\t", i, j, t.count);
            }
            StdOut.println();
        }

        for (int i = 1; i != 5; i++) {
            for (int j = 0; j != i + 1; j++) {
                StdOut.printf("C(%d, %d) = %d\t", i, j, TwentySeven.binomial(i, j));
            }
            StdOut.println();
        }
    }
}
