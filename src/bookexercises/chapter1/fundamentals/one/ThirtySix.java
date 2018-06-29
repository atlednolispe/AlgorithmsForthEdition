package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Empirical shuffle check. Run computational experiments to check that our
 * shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
 * command-line arguments M and N, does N shuffles of an array of size M that is initial-
 * ized with a[i] = i before each shuffle, and prints an M-by-M table such that row i
 * gives the number of times i wound up in position j for all j. All entries in the array
 * should be close to N/M.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtySix {
    public void showTable(int[][] table)
    {
        int M = table.length;
        StdOut.print("\t");
        for (int i = 0; i != M; ++i)
        {
            StdOut.print(i + "     \t");
        }
        StdOut.println();
        for (int i = 0; i != M; ++i)
        {
            StdOut.print(i+ "\t");
            for (int j = 0; j != M; ++j)
            {
                StdOut.print(table[i][j] + "\t");
            }
            StdOut.println();
        }
    }

    public void resetArray(int[] array)
    {
        for (int i = 0; i != array.length; ++i)
        {
            array[i] = i;
        }
    }

    public void shuffle(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int r = i + StdRandom.uniform(N-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public int[][] shuffleResult(int M, int N)
    {
        int[][] result = new int[M][M];
        int[] array = new int[M];

        for (int k = 0; k != N; ++k)
        {
            resetArray(array);
            shuffle(array);
            // after shuffle, array[i] show in the place i
            for (int i = 0; i != array.length; ++i)
            {
                result[array[i]][i] += 1;
            }
        }

        return result;
    }

    public void shuffleCheck(int M, int N)
    {
        int[][] result = shuffleResult(M, N);
        showTable(result);
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        ThirtySix instance = new ThirtySix();
        instance.shuffleCheck(M, N);
    }
}
