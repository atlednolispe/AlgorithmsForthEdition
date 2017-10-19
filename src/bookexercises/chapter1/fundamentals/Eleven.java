package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Write a code fragment that prints the contents of a two-dimensional
 * boolean array, using * to represent true and a space to represent false.
 * Include row and column numbers.
 */
public class Eleven {
    public static void showBooleanArray(Boolean[][] array) {
        for (int i = 0; i != array.length; ++i)
        {
            for (int j = 0; j != array[i].length; ++j)
            {
                if (array[i][j] == true)
                    StdOut.printf("[%d][%d]:%c ", i, j, '*');
                else
                    StdOut.printf("[%d][%d]:%c ", i, j, ' ');
                if (j == array[i].length - 1)
                    StdOut.print('\n');
            }
        }
    }
    public static void main(String[] args) {
        Eleven.showBooleanArray(new Boolean[][]{{true, false, true}, {true, true, true},
                {false, true, true}});
    }
}
