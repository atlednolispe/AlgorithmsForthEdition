package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Use mathematical induction to prove that Euclid's algorithm computes the
 * greatest common divisor of any pair of nonnegative integers p and q.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2017/10/26
 */
public class TwentyFive {
    /**
     * Proof:
     *
     * If q = 0, gcd(p, q) = p, then q > 0.
     * Assume gcd(q, r) = g, r = p % q, p = mq +r
     * Then g | q, g | r
     * <=>  q = k1*g, r = k2*g && (k1, k2) = 1
     *      p = (m*k1 + k2)*g
     *      q = k1*g
     * <=>  gcd(p, q) = ng
     *      n | k1
     *      n | m*k1 + k2
     * <=>  n | k2
     *      n | k1
     * Because of (k1, k2) = 1, then n = 1, then gcd(p, q) = g.
     * Done.
     *
     */
    public static int gcd(int p, int q)
    {
        StdOut.printf("p: %d, q: %d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {

    }
}
