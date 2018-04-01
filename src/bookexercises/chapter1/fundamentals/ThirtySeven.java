package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Bad shuffling. Suppose that you choose a random integer between 0 and N-1
 * in our shuffling code instead of one between i and N-1. Show that the resulting order is
 * not equally likely to be one of the N! possibilities. Run the test of the previous exercise
 * for this version.
 *
 * Why will this shuffle lead to make mistake?
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtySeven extends ThirtySix{
    /**
     * 若ThirtySix中方法都为static方法好像无法通过重写shuffle达到继承的效果,java的基础真是一点都没有呀,
     * 之后研究一下。
     */
    @Override
    public void shuffle(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int r = StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        ThirtySeven instance = new ThirtySeven();
        instance.shuffleCheck(M, N);
    }

}
