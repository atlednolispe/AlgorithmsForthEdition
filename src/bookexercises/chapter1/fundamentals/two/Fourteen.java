package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Using our implementation of equals() in Date as a model(page103), develop
 * implementations of equals() for Transaction.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/5
 */
public class Fourteen extends Transaction {
    public Fourteen(String who, Date when, double amount) {
        super(who, when, amount);
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
        Fourteen x = (Fourteen) that;
        // if (this.who() != x.who())
        // object ==: compare the memory address, not the value
        if (!this.who().equals(x.who()))
        {
            return false;
        }
        if (!this.when().equals(x.when()))
        {
            return false;
        }
        if (this.amount() != x.amount())
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Fourteen f1 = new Fourteen("hello", new Date(7, 5, 2018), 20);
        Fourteen f2 = new Fourteen("hello", new Date(7, 5, 2018), 20);
        StdOut.println(f1.equals(f2));
    }
}
