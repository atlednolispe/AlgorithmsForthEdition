package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * Rational numbers. Implement an immutable data type Rational for rational
 * numbers that supports addition, subtraction, multiplication, and division.
 *
 * public class Rational
 * -----------------------------------------------------------------------------
 *              Rational(int numerator. int denominator)
 * Rational     plus(Rational b)        sum of this number and b
 * Rational     minus(Rational b)       difference of this number and b
 * Rational     times(Rational b)       product of this number and b
 * Rational     divides(Rational b)     quotient of this number and b
 *  boolean     equals(Rational that)   is this number equal to that ?
 *   String     toString()              string representation
 *
 * You do not have to worry about testing for overflow (see Exercise 1.2.17), but use as
 * instance variables two long values that represent the numerator and denominator to
 * limit the possibility of overflow. Use Euclid’s algorithm (see page 4) to ensure that the
 * numerator and denominator never have any common factors. Include a test client that
 * exercises all of your methods.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/5
 */
public class Sixteen {
}


class Rational {
    private int sign;
    private long numerator;
    private long denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0)
        {
            throw new IllegalArgumentException("Illegal denominator!");
        }
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

    private void unifySign(int numerator, int denominator) {
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

    public static Rational generateRationalFromLong(long newNumerator, long newDenominator) {
        long factor = gcd(newNumerator, newDenominator);
        int p = (int) (newNumerator / factor);
        int q = (int) (newDenominator / factor);

        return new Rational(p, q);
    }

    public Rational plus(Rational b) {
        long newDenominator = this.denominator * b.denominator / gcd(this.denominator, b.denominator );
        long newNumerator = this.numerator * newDenominator / this.denominator + b.numerator * newDenominator / newDenominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public Rational minus(Rational b) {
        long newDenominator = this.denominator * b.denominator / gcd(this.denominator, b.denominator );
        long newNumerator = this.numerator * newDenominator / this.denominator - b.numerator * newDenominator / newDenominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public Rational times(Rational b) {
        long newDenominator = this.denominator * b.denominator;
        long newNumerator = this.numerator * b.numerator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public Rational divides(Rational b) {
        long newDenominator = this.denominator * b.numerator;
        long newNumerator = this.numerator * b.denominator;

        return generateRationalFromLong(newNumerator, newDenominator);
    }

    public boolean equals(Rational that) {
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
        Rational r1 = new Rational(-2, -5);
        Rational r2 = new Rational(-40, -100);

        Rational plus = r1.plus(r2);
        Rational minus = r1.minus(r2);
        Rational times = r1.times(r2);
        Rational divides = r1.divides(r2);

        boolean eq = r1.equals(r2);

        StdOut.println(r1);
        StdOut.println(r2);
        StdOut.println(plus);
        StdOut.println(minus);
        StdOut.println(times);
        StdOut.println(divides);
        StdOut.println(eq);
        StdOut.println(new Rational(0, -10));
        StdOut.println(new Rational(0, 10));

        StdOut.println(new Rational(-3*5*7*11, 3*5*13));
    }
}
