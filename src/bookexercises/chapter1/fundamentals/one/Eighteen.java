package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * What are the values of mystery(2, 25) and mystery(3, 11)?
 * Given positive integers a & b, describe what value mystery(a, b) computes.
 * Answer the same question, but replace + with * and replace return 0 with return 1.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/21
 */
public class Eighteen {
    /**
     * @param a
     * @param b
     * @return a*b
     */
    public static int mystery(int a, int b)
    {
        if (b == 0) {
            StdOut.println("mystery(0)");
            return 0;
        }
        if (b % 2 == 0) {
            StdOut.printf("mystery(%d + %d, %d / 2)\n", a, a, b);
            return mystery(a + a, b / 2);
        }
        StdOut.printf("mystery(%d + %d, %d / 2) + %d\n", a, a, b, a);
        return mystery(a+a, b/2) + a;
    }

    /**
     * @param a
     * @param b
     * @return a^b
     */
    public static long mystery_multiply(long a, long b)
    {
        if (b == 0) {
            StdOut.println("mystery_multiply(1)");
            return 1;
        }
        if (b % 2 == 0) {
            StdOut.printf("mystery_multiply(%d * %d, %d / 2)\n", a, a, b);
            return mystery_multiply(a * a, b / 2);
        }
        StdOut.printf("mystery_multiply(%d * %d, %d / 2) * %d\n", a, a, b, a);
        return mystery_multiply(a*a, b/2) * a;
    }

    public static void main(String[] args) {
        /**
         * 1. m(2, 25)
         * 2. m(4, 12) + 2
         * 3. m(8, 6) + 2
         * 4. m(16, 3) + 2
         * 5. m(32, 1) + 2 + 16
         * 6. m(64, 0) + 2 + 16 + 32
         */
        int[] testA = new int[]{2, 3, 4};
        int[] testB = new int[]{25, 27, 30};

        for (int i: testA)
        {
            for (int j: testB)
            {
                StdOut.printf("a: %d, b: %d\n", i, j);
                StdOut.println(Integer.toBinaryString(j));

                StdOut.println(Eighteen.mystery(i, j));

                StdOut.println(Eighteen.mystery_multiply(i, j));
            }
        }
    }
}
