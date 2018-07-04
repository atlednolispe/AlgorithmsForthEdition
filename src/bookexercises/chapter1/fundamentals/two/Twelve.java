package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Add a method dayOfTheWeek() to SmartDate that returns a String value
 * Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the ap-
 * propriate day of the week for the date. You may assume that the date is in the 21st
 * century.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/2
 */
public class Twelve extends Eleven {
    public Twelve (int month, int day, int year) {
        super(month, day, year);
        if (year() < 2000 || year() > 2099)
        {
            throw new IllegalArgumentException("year should between 2000 to 2099");
        }
    }

    public String dayOfTheWeek() {
        // 20000101 Sat
        String[] week = new String[]{ "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] leapYear = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] commonYear = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = year();
        int month = month();
        int day = day();

        // calculate the interval days from 1999/12/31
        int interval = 0;
        for (int y = 2000; y != year; ++y)
        {
            if (leapYearOrCommon(y))
            {
                interval += 366;
            }
            else
            {
                interval += 365;
            }
        }
        if (leapYearOrCommon(year))
        {
            for (int m = 0; m != month; ++m)
            {
                interval += leapYear[m];
            }
        }
        else
        {
            for (int m = 0; m != month; ++m)
            {
                interval += commonYear[m];
            }
        }
        interval += day;

        return week[interval % 7];
    }

    private boolean leapYearOrCommon(int year) {
        boolean leapYearOrCommon = false;
        if (year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0)
        {
            leapYearOrCommon = true;
        }
        return leapYearOrCommon;
    }

    public static void main(String[] args) {
        // 2018/07/04 - Wed
        Twelve t = new Twelve(7, 4, 2018);
        StdOut.println(t.dayOfTheWeek());
    }
}