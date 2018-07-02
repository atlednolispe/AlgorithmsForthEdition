package bookexercises.chapter1.fundamentals.two;

import java.util.stream.IntStream;
import edu.princeton.cs.algs4.StdOut;

/**
 * Develop an implementation SmartDate of our Date API that raises an excep-
 * tion if the date is not legal.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/2
 */
public class Eleven {
    private int month;
    private int day;
    private int year;

    public Eleven(int month, int day, int year) {
        boolean legal = legalDateOrNot(month, day, year);
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Eleven(String date) {
        String[] mmddyyyy = date.split("/");
        int month = Integer.parseInt(mmddyyyy[0]);
        int day = Integer.parseInt(mmddyyyy[1]);
        int year = Integer.parseInt(mmddyyyy[2]);
        boolean legal = legalDateOrNot(month, day, year);
        this.month = month;
        this.day = day;
        this.year = year;
    }

    private boolean legalDateOrNot(int month, int day, int year) {
        int[] longMonth = new int[]{1, 3, 5, 7, 8, 10, 12};
        int[] shortMonth = new int[]{4, 6, 9, 11};
        boolean legal = day > 0
                && (
                (IntStream.of(longMonth).anyMatch(x -> x == month) && day < 32)
                        || (IntStream.of(shortMonth).anyMatch(x -> x == month) && day < 31)
                        || month == 2 && day < 29
                        || (year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0) && day == 29
        );

        if (!legal)
        {
            throw new IllegalArgumentException();
        }
        return legal;
    }

    public int month() {
        return this.month;
    }

    public int day() {
        return this.day;
    }

    public int year() {
        return this.year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%4d", month, day, year);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
        {
            return true;
        }
        if (that == null)
        {
            return false;
        }
        if (this.getClass() != that.getClass())
        {
            return false;
        }
        Eleven x = (Eleven) that;
        if (this.month != x.month)
        {
            return false;
        }
        if (this.day != x.day)
        {
            return false;
        }
        if (this.year != x.year)
        {
            return false;
        }
        return true;
    }

    public int compareTo(Eleven that) {
        String formatThis = String.format("%4d/%02d/%02d", this.year, this.month, this.day);
        String formatThat = String.format("%4d/%02d/%02d", that.year, that.month, that.day);
        return formatThis.compareTo(formatThat);
    }

    @Override
    public int hashCode() {
        // what is it?
        return super.hashCode();
    }

    public static void main(String[] args) {
        Eleven date1 = new Eleven(7, 1, 2009);
        Eleven date2 = new Eleven("6/7/2012");

        StdOut.println(date1);
        StdOut.printf("month: %d, day: %d, year: %d\n", date1.month(), date1.day(), date1.year());
        StdOut.println(date1.compareTo(date2));

//        Eleven date3 = new Eleven("02/29/2100");
    }
}
