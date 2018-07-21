package bookexercises.chapter1.fundamentals.five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/20
 */
public class PercolationStats {
    private double[] statsArray;
    private int n;
    private int trials;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    /**
     * perform trials independent experiments on an n-by-n grid
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
        {
            throw new IllegalArgumentException("n and trials should be bigger than 0");
        }

        this.trials = trials;

        statsArray = new double[trials];
        for (int trial = 0; trial != this.trials; ++trial)
        {
            int[] randomSites = new int[n * n];
            for (int i = 1; i != randomSites.length + 1; ++i)
            {
                randomSites[i - 1] = i;
            }
            StdRandom.shuffle(randomSites);
            Percolation p = new Percolation(n);
            int randomSiteIndex = 0;
            while (!p.percolates())
            {
                p.open((randomSites[randomSiteIndex] - 1) / n + 1, (randomSites[randomSiteIndex] - 1) % n + 1);
                randomSiteIndex += 1;
            }
            statsArray[trial] = (double) p.numberOfOpenSites() / n / n;
        }

        mean = StdStats.mean(statsArray);
        stddev = StdStats.stddev(statsArray);
        confidenceLo = mean - 1.96 * stddev / Math.sqrt(n);
        confidenceHi = mean + 1.96 * stddev / Math.sqrt(n);
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean()
    {
        return mean;
    }

    /**
     * sample standard deviation of percolation threshold
     */
    public double stddev() {
        return stddev;
    }

    /**
     * low  endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return confidenceLo;
    }

    /**
     * high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return confidenceHi;
    }

    /**
     * test client (described below)
     */
    public static void main(String[] args) {
//        PercolationStats p = new PercolationStats(2, 10000);
        PercolationStats p = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println(String.format("%-23s", "mean") + " = " + p.mean());
        StdOut.println(String.format("%-23s", "stddev") + " = " + p.stddev());
        StdOut.println(String.format("%-23s", "95% confidence interval") + " = [" + p.confidenceLo() + ", " + p.confidenceHi() + "]");
    }
}
