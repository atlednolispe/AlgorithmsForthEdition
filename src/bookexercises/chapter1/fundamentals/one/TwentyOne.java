package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a program that reads in lines from standard input with each line containing
 * a name and two integers and then uses printf() to print a table with a column of
 * the names, the integers, and the result of dividing the first by the second, accurate to
 * three decimal places. You could use a program like this to tabulate batting averages for
 * baseball players or grades for students.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/25
 */
public class TwentyOne {
    /**
     * name should be in English, or format is in mess.
     */
    public static void tabulate()
    {
        String sepapator = "---------------------------------------------";
        StdOut.println(sepapator);
        StdOut.printf("|%10s|%10s|%10s|%10s|\n", "Name:", "Integer1", "Integer2", "Result");
        StdOut.println(sepapator);
        while(!StdIn.isEmpty())
        {
            String name = StdIn.readString();
            int int1 = StdIn.readInt();
            int int2 = StdIn.readInt();
            double result = 1.0*int1/int2;
            StdOut.printf("|%10s|%10d|%10d|%10.3f|\n", name, int1, int2, result);
            StdOut.println(sepapator);
        }
    }

    /**
     * test contents
     *
     * aa 1 3
     * bb 2 9
     * cc 98 100
     * dd 4 7
     * ee 8 3
     */
    public static void main(String[] args) {
        TwentyOne.tabulate();
    }
}
