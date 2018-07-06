package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Parsing. Develop the parse constructors for your Date and Transaction im-
 * plementations of Exercise 1.2.13 that take a single String argument to specify the
 * initialization values, using the formats given in the table below.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/6
 */
public class Nineteen {
    private String who;
    private Date when;
    private double amount;

    public Nineteen(String transaction) {
        // who mm/dd/yyyy amount
        String[] trans = transaction.split(" ");
        String[] date = trans[1].split("/");
        this.who = trans[0];
        this.when = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        this.amount = Double.parseDouble(trans[2]);

        StdOut.println(who);
        StdOut.println(when);
        StdOut.println(amount);
    }

    public static void main(String[] args) {
        Nineteen n = new Nineteen("Turing 5/22/1939 11.99");
    }
}
