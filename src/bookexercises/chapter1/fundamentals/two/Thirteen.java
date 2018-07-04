package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Using our implementation of Date as a model(page91),develop an implementa-
 * tion of Transaction.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/4
 */
public class Thirteen {
    public static void main(String[] args) {

    }
}


class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m; day = d; year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}


class Transaction implements Comparable<Transaction> {
    private String who;
    private Date when;
    private double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        // mm/dd/yyyy who amount
        String[] trans = transaction.split(" ");
        String[] date = trans[0].split("/");
        this.who = trans[1];
        this.when = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        this.amount = Double.parseDouble(trans[2]);
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return when() + " " + who() + " " + String.format("%.3f", amount());
    }

    @Override
    public int compareTo(Transaction that) {
        return this.toString().compareTo(that.toString());
    }

    public static void main(String[] args) {
        Transaction trans1 = new Transaction("aaa", new Date(7, 4, 2018), 100.123);
        Transaction trans2 = new Transaction("07/04/2018 aaa 100.123");
        Transaction trans3 = new Transaction("07/04/2018 aaa 100.124");

        StdOut.println(trans1.compareTo(trans2));
        StdOut.println(trans1.compareTo(trans3));
    }
}