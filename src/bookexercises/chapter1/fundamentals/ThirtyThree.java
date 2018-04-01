package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Matrix library. Write a library Matrix that implements the following API:
 *
 * public class Matrix
 * ------------------------------------------------------------------------------
 * static   double      dot(double[] x, double[] y)         vector dot product
 * static   double[][]  mult(double[][] a, double[][] b)    matrix-matrix product
 * static   double[][]  transpose(double[][] a)             transpose
 * static   double[]    mult(double[][] a, double[] x)      matrix-vector product
 * static   double[]    mult(double[] y, double[][] a)      vector-matrix product
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/4/1
 */
public class ThirtyThree {
    public static double dot(double[] x, double[] y)
    {
        double result = 0;

        for (int i = 0; i != x.length; ++i)
        {
            result += x[i] * y[i];
        }

        return result;
    }

    public static double[] getColumn(double[][] matrix, int column)
    {
        double[] result = new double[matrix.length];

        for (int i = 0; i != result.length; ++i)
        {
            result[i] = matrix[i][column];
        }

        return result;
    }

    public static double[][] mult(double[][] a, double[][] b)
    {
        int row = a.length, column = b[0].length;
        double[][] result = new double[row][column];

        for (int i = 0; i != row; ++i)
        {
            for (int j = 0; j != column; ++j)
            {
                double[] bj = getColumn(b, j);
                result[i][j] = dot(a[i], bj);
            }
        }

        return result;
    }

    public static double[][] transpose(double[][] a)
    {
        int row = a[0].length, column = a.length;
        double[][] result = new double[row][column];

        for (int i = 0; i != row; ++i)
        {
            for (int j = 0; j != column; ++j)
            {
                result[i][j] = a[j][i];
            }
        }

        return result;
    }

    public static double[] mult(double[][] a, double[] x)
    {
        int row = a.length;
        double[] result = new double[row];

        for (int i = 0; i != row; ++i)
        {
            result[i] = dot(a[i], x);
        }

        return result;
    }

    public static double[] mult(double[] y, double[][] a)
    {
        int column = a[0].length;
        double[] result = new double[column];

        for (int j = 0; j != column; ++j)
        {
            double[] aj = getColumn(a, j);
            result[j] = dot(y, aj);
        }

        return result;
    }

    public static void showVector(double[] vector)
    {
        for (int i = 0; i != vector.length; ++i)
        {
            StdOut.print(vector[i] + "\t");
        }
        StdOut.println();
    }

    public static void showMatrix(double[][] matrix)
    {
        for (int i = 0; i != matrix.length; ++i)
        {
            showVector(matrix[i]);
        }
    }

    public static void main(String[] args) {
        double[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
        };

        double[][] matrix2 = {
                {1, 2},
                {3, 4},
                {5, 6},
        };

        showMatrix(matrix1);
        StdOut.println();
        showMatrix(matrix2);
        StdOut.println();

        double[][] result = mult(matrix1, matrix2);
        showMatrix(result);
        StdOut.println();

        showVector(mult(matrix1[0], matrix2));
        StdOut.println();
        showVector(mult(matrix1, getColumn(matrix2, 0)));
        StdOut.println();
    }
}
