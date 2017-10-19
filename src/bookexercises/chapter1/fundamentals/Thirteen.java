package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Matrix transposition
 */
public class Thirteen {
    public static int[][] transposition(int[][] m){
//        Add exception later
//        if (m.length == 0 || m[0].length == 0)
        int[][] tr = new int[m[0].length][m.length];
        for (int i = 0; i != m[0].length; ++i)
            for (int j = 0; j != m.length; ++j)
                tr[i][j] = m[j][i];
        return tr;
    }
    public static void main(String[] args) {
        int[][] tr = Thirteen.transposition(new int[][]{{1, 2, 3}, {4, 5, 6}});
        for (int i = 0; i != tr.length; ++i)
            StdOut.println(Arrays.toString(tr[i]));
    }
}
