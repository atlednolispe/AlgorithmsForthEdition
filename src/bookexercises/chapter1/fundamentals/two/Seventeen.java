package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Robust implementation of rational numbers. Use assertions to develop an im-
 * plementation of Rational (see Exercise 1.2.16) that is immune to overflow.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/6
 */
public class Seventeen {
}

class RationalVerifyOverflow {
    private int sign;
    private long numerator;
    private long denominator;

    public RationalVerifyOverflow(int numerator, int denominator) {
        if (denominator == 0)
        {
            throw new IllegalArgumentException("Illegal denominator!");
        }
        // can't extends, super must be the first statement
        assert numerator > Integer.MIN_VALUE && numerator < Integer.MAX_VALUE : "numerator is overflow";
        assert denominator > Integer.MIN_VALUE && denominator < Integer.MAX_VALUE : "denominator is overflow";

        unifySign(numerator, denominator);
        long factor = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / factor;
        this.denominator = this.denominator / factor;
    }

    public static long gcd(long p, long q) {
        if (q == 0)
        {
            return p;
        }
        long r = p % q;
        return gcd(q, r);
    }

    public void unifySign(int numerator, int denominator) {
        if (numerator < 0 != denominator < 0)
        {
            this.sign = -1;
        }
        else
        {
            this.sign = 1;
        }
        if (numerator == 0 || denominator == 0)
        {
            this.sign = 1;
        }
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
    }

    public static RationalVerifyOverflow generateRationalFromLong(long newNumerator, long newDenominator) {
        long factor = gcd(newNumerator, newDenominator);
        int p = (int) (newNumerator / factor);
        int q = (int) (newDenominator / factor);

        return new RationalVerifyOverflow(p, q);
    }

    public RationalVerifyOverflow plus(RationalVerifyOverflow b) {
        long newDenominator = this.denominator * b.denominator / gcd(this.denominator, b.denominator );
        long newNumerator = this.numerator * newDenominator / this.denominator + b.numerator * newDenominator / newDenominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public RationalVerifyOverflow minus(RationalVerifyOverflow b) {
        long newDenominator = this.denominator * b.denominator / gcd(this.denominator, b.denominator );
        long newNumerator = this.numerator * newDenominator / this.denominator - b.numerator * newDenominator / newDenominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public RationalVerifyOverflow times(RationalVerifyOverflow b) {
        long newDenominator = this.denominator * b.denominator;
        long newNumerator = this.numerator * b.numerator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public RationalVerifyOverflow divides(RationalVerifyOverflow b) {
        long newDenominator = this.denominator * b.numerator;
        long newNumerator = this.numerator * b.denominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public boolean equals(RationalVerifyOverflow that) {
        if (this.sign != that.sign)
        {
            return false;
        }
        if (this.numerator != that.numerator)
        {
            return false;
        }
        if (this.denominator != that.denominator)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.sign == 1)
        {
            return "+ " + this.numerator + " / " + this.denominator;
        }
        else
        {
            return "- " + this.numerator + " / " + this.denominator;
        }
    }

    public static void main(String[] args) {
        // java -ea XXX: open assert
        // javac -cp XXX
        RationalVerifyOverflow r = new RationalVerifyOverflow(2147483647 + 1, 99);
    }
}
