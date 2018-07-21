package bookexercises.chapter1.fundamentals.five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Open sites in row 1 or n are union by mistake,
 * open sites in row 1 are rooted on head, and open sites in row n are rooted on tail,
 * they may be not unioned in fact, so don't pass the test.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/20
 */
public class Percolation {
    private int n;
    private boolean[][] openSites;
    private int numberOfOpenSites;
    private WeightedQuickUnionUF uf;
    private int head;
    private int tail;

    /**
     * create n-by-n grid, with all sites blocked
     */
    public Percolation(int n) {
        if (n <= 0)
        {
            throw new IllegalArgumentException("n should be bigger than 0");
        }

        this.n = n;
        openSites = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        head = 0;
        tail = n * n + 1;
    }

    /**
     * open site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        boolean validRow = row > 0 && row < n + 1;
        boolean validCol = col > 0 && col < n + 1;

        if (!(validRow && validCol))
        {
            throw new IllegalArgumentException("row and col should between 1 and " + n);
        }

        if (!isOpen(row, col))
        {
            openSites[row - 1][col - 1] = true;
            numberOfOpenSites += 1;
        }
        else
        {
            return;
        }

        int leftCol = col - 1;
        int rightCol = col + 1;
        int upperRow = row - 1;
        int lowerRow = row + 1;
        /**
         * sites in grid are represented from 1 to n * n,
         * 0 is the head, n * n + 1 is the tail
         */
        int index = n * (row - 1) + col;

        /**
         * ERROR!!!
         */
        if (row == 1)
        {
            uf.union(index, head);
        }
        if (row == n)
        {
            uf.union(index, tail);
        }

        /**
         * union the neighborhoods are opened
         */
        if (leftCol > 0 && isOpen(row, leftCol))
        {
            uf.union(index, index - 1);
        }
        if (rightCol <= n && isOpen(row, rightCol))
        {
            uf.union(index, index + 1);
        }
        if (upperRow > 0 && isOpen(upperRow, col))
        {
            uf.union(index, index - n);
        }
        if (lowerRow <= n && isOpen(lowerRow, col))
        {
            uf.union(index, index + n);
        }
    }

    /**
     * is site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        boolean validRow = row > 0 && row < n + 1;
        boolean validCol = col > 0 && col < n + 1;

        if (!(validRow && validCol))
        {
            throw new IllegalArgumentException("row and col should between 1 and " + n);
        }

        return openSites[row - 1][col - 1];
    }

    /**
     * is site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        boolean validRow = row > 0 && row < n + 1;
        boolean validCol = col > 0 && col < n + 1;

        if (!(validRow && validCol))
        {
            throw new IllegalArgumentException("row and col should between 1 and " + n);
        }

        return uf.connected(head, n * (row - 1) + col);
    }

    /**
     * number of open sites
     */
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    /**
     * does the system percolate?
     */
    public boolean percolates() {
        return uf.connected(head, tail);
    }

    /**
     * test client (optional)
     */
    public static void main(String[] args) {
        int size = 20;
        int[] randomSites = new int[size * size];
        for (int i = 1; i != randomSites.length + 1; ++i)
        {
            randomSites[i - 1] = i;
        }
        StdRandom.shuffle(randomSites);

        Percolation p = new Percolation(size);

        int randomSiteIndex = 0;
        while (!p.percolates())
        {
            p.open((randomSites[randomSiteIndex] - 1) / size + 1, (randomSites[randomSiteIndex] - 1) % size + 1);
            randomSiteIndex += 1;
        }

        StdOut.println((double) p.numberOfOpenSites() / size / size);

//        int size = StdIn.readInt();
//        Percolation p = new Percolation(size);
//
//        while (!StdIn.isEmpty())
//        {
//            int row = StdIn.readInt();
//            int col = StdIn.readInt();
//            p.open(row, col);
//            if (!p.isFull(18, 1))
//            {
//                StdOut.println(p.uf.find(17 * size + 1));
//                StdOut.println(p.uf.find(0));
//            }
//        }
    }
}

/**
 * Score: 92
 *
 * See the Assessment Guide for information on how to interpret this report.
 *
 * ASSESSMENT SUMMARY
 *
 * Compilation:  PASSED
 * API:          PASSED
 *
 * Findbugs:     FAILED (1 warning)
 * PMD:          PASSED
 * Checkstyle:   FAILED (0 errors, 3 warnings)
 *
 * Correctness:  26/30 tests passed
 * Memory:       8/8 tests passed
 * Timing:       20/20 tests passed
 *
 * Aggregate score: 92.00%
 * [Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]
 *
 * ASSESSMENT DETAILS
 *
 * The following files were submitted:
 * ----------------------------------
 * 4.0K Jul 20 14:54 Percolation.java
 * 2.7K Jul 20 14:54 PercolationStats.java
 *
 *
 * ********************************************************************************
 * *  COMPILING
 * ********************************************************************************
 *
 *
 * % javac Percolation.java
 * *-----------------------------------------------------------
 *
 * % javac PercolationStats.java
 * *-----------------------------------------------------------
 *
 *
 * ================================================================
 *
 *
 * Checking the APIs of your programs.
 * *-----------------------------------------------------------
 * Percolation:
 *
 * PercolationStats:
 *
 * ================================================================
 *
 *
 * ********************************************************************************
 * *  CHECKING STYLE AND COMMON BUG PATTERNS
 * ********************************************************************************
 *
 *
 * % findbugs *.class
 * *-----------------------------------------------------------
 * M P UUF_UNUSED_FIELD UuF: The instance (or static) variable 'n' is never used. Consider removing it from the class.  In PercolationStats.java
 * Warnings generated: 1
 *
 *
 * ================================================================
 *
 *
 * % pmd .
 * *-----------------------------------------------------------
 * Percolation.java:11: The private instance (or static) variable 'n' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * Percolation.java:14: The private instance (or static) variable 'uf' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * Percolation.java:15: The private instance (or static) variable 'head' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * Percolation.java:16: The private instance (or static) variable 'tail' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:11: Can you replace the instance (or static) variable 'statsArray' with a local variable? [SingularField]
 * PercolationStats.java:11: The private instance (or static) variable 'statsArray' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:12: Avoid unused private instance (or static) variables, such as 'n'. [UnusedPrivateField]
 * PercolationStats.java:13: Can you replace the instance (or static) variable 'trials' with a local variable? [SingularField]
 * PercolationStats.java:13: The private instance (or static) variable 'trials' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:14: The private instance (or static) variable 'mean' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:15: The private instance (or static) variable 'stddev' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:16: The private instance (or static) variable 'confidenceLo' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PercolationStats.java:17: The private instance (or static) variable 'confidenceHi' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
 * PMD ends with 13 warnings.
 *
 *
 * ================================================================
 *
 *
 * % checkstyle *.java
 * *-----------------------------------------------------------
 *
 * % custom checkstyle checks for Percolation.java
 * *-----------------------------------------------------------
 * [WARN] Percolation.java:1: We recommend defining at least one private helper method, e.g., to validate the row and column indices or to map from 2D to 1D indices. [Design]
 * Checkstyle ends with 0 errors and 1 warning.
 *
 * % custom checkstyle checks for PercolationStats.java
 * *-----------------------------------------------------------
 * [WARN] PercolationStats.java:1: The number (0) of calls to 'Integer.parseInt()' must equal the number (2) of integer command-line arguments. [CommandLineArgument]
 * [WARN] PercolationStats.java:1:1: The constant '1.96' appears more than once. Define a constant variable (such as 'CONFIDENCE_95') to hold the constant '1.96'. [NumericLiteralCount]
 * Checkstyle ends with 0 errors and 2 warnings.
 *
 *
 * ================================================================
 *
 *
 * ********************************************************************************
 * *  TESTING CORRECTNESS
 * ********************************************************************************
 *
 * Testing correctness of Percolation
 * *-----------------------------------------------------------
 * Running 15 total tests.
 *
 * Tests 1 through 8 create a Percolation object using your code, then repeatedly
 * open sites by calling open(). After each call to open(), it checks the return
 * values of isOpen(), percolates(), numberOfOpenSites(), and isFull() in that order.
 * Except as noted, a site is opened at most once.
 *
 * Tests 13 through 15 test backwash.
 *
 * Test 1: open predetermined list of sites using file inputs
 *   * filename = input6.txt
 *   * filename = input8.txt
 *   * filename = input8-no.txt
 *   * filename = input10-no.txt
 *   * filename = greeting57.txt
 *   * filename = heart25.txt
 * ==> passed
 *
 * Test 2: open random sites until just before system percolates
 *   * n = 3
 *   * n = 5
 *   * n = 10
 *   * n = 10
 *   * n = 20
 *   * n = 20
 *   * n = 50
 *   * n = 50
 * ==> passed
 *
 * Test 3: open predetermined sites for n = 1 and n = 2 (corner case test)
 *   * filename = input1.txt
 *   * filename = input1-no.txt
 *   * filename = input2.txt
 *   * filename = input2-no.txt
 * ==> passed
 *
 * Test 4: check predetermined sites with long percolating path
 *   * filename = snake13.txt
 *   * filename = snake101.txt
 * ==> passed
 *
 * Test 5: open every site
 *   * filename = input5.txt
 * ==> passed
 *
 * Test 6: open random sites until just before system percolates,
 *         allowing open() to be called on a site more than once
 *   * n = 3
 *   * n = 5
 *   * n = 10
 *   * n = 10
 *   * n = 20
 *   * n = 20
 *   * n = 50
 *   * n = 50
 * ==> passed
 *
 * Test 7: call methods with invalid arguments
 *   * n = 10, (row, col) = (-1, 5)
 *   * n = 10, (row, col) = (11, 5)
 *   * n = 10, (row, col) = (0, 5)
 *   * n = 10, (row, col) = (5, -1)
 *   * n = 10, (row, col) = (5, 11)
 *   * n = 10, (row, col) = (5, 0)
 *   * n = 10, (row, col) = (-2147483648, -2147483648)
 *   * n = 10, (row, col) = (2147483647, 2147483647)
 * ==> passed
 *
 * Test 8: call constructor with invalid argument
 *   * n = -10
 *   * n = -1
 *   * n = 0
 * ==> passed
 *
 * Test 9: create multiple Percolation objects at the same time
 *         (to make sure you didn't store data in static variables)
 * ==> passed
 *
 * Test 10: open predetermined list of sites using file inputs,
 *          but permute the order in which methods are called
 *   * filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
 *   * filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
 *   * filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
 *   * filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
 *   * filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
 *   * filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
 * ==> passed
 *
 * Test 11: call all methods in random order until just before system percolates
 *   * n = 3
 *   * n = 5
 *   * n = 7
 *   * n = 10
 *   * n = 20
 *   * n = 50
 * ==> passed
 *
 * Test 12: call all methods in random order until almost all sites are open,
 *          but with inputs not prone to backwash
 *   * n = 3
 *   * n = 5
 *   * n = 7
 *   * n = 10
 *   * n = 20
 *   * n = 50
 * ==> passed
 *
 * Test 13: check for backwash with predetermined sites
 *   * filename = input20.txt
 *     - isFull() returns wrong value after 231 sites opened
 *     - student   isFull(18, 1) = true
 *     - reference isFull(18, 1) = false
 *   * filename = input10.txt
 *     - isFull() returns wrong value after 56 sites opened
 *     - student   isFull(9, 1) = true
 *     - reference isFull(9, 1) = false
 *   * filename = input50.txt
 *     - isFull() returns wrong value after 1412 sites opened
 *     - student   isFull(22, 28) = true
 *     - reference isFull(22, 28) = false
 *   * filename = jerry47.txt
 *     - isFull() returns wrong value after 1076 sites opened
 *     - student   isFull(11, 47) = true
 *     - reference isFull(11, 47) = false
 *   * filename = sedgewick60.txt
 *     - isFull() returns wrong value after 1577 sites opened
 *     - student   isFull(21, 59) = true
 *     - reference isFull(21, 59) = false
 *   * filename = wayne98.txt
 *     - isFull() returns wrong value after 3851 sites opened
 *     - student   isFull(69, 9) = true
 *     - reference isFull(69, 9) = false
 * ==> FAILED
 *
 * Test 14: check for backwash with predetermined sites that have
 *          multiple percolating paths
 *   * filename = input3.txt
 *     - isFull() returns wrong value after 4 sites opened
 *     - student   isFull(3, 1) = true
 *     - reference isFull(3, 1) = false
 *   * filename = input4.txt
 *     - isFull() returns wrong value after 7 sites opened
 *     - student   isFull(4, 4) = true
 *     - reference isFull(4, 4) = false
 *   * filename = input7.txt
 *     - isFull() returns wrong value after 12 sites opened
 *     - student   isFull(6, 1) = true
 *     - reference isFull(6, 1) = false
 * ==> FAILED
 *
 * Test 15: call all methods in random order until all sites are open,
 *          allowing isOpen() to be called on a site more than once
 *          (these inputs are prone to backwash)
 *   * n = 3
 *     - isFull() returns wrong value after 6 sites opened
 *     - student   isFull(2, 1) = true
 *     - reference isFull(2, 1) = false
 *     - failed on trial 14 of 40
 *
 *   * n = 5
 *     - isFull() returns wrong value after 16 sites opened
 *     - student   isFull(2, 4) = true
 *     - reference isFull(2, 4) = false
 *     - failed on trial 3 of 20
 *
 *   * n = 7
 *     - isFull() returns wrong value after 30 sites opened
 *     - student   isFull(5, 1) = true
 *     - reference isFull(5, 1) = false
 *     - failed on trial 1 of 10
 *
 *   * n = 10
 *     - isFull() returns wrong value after 64 sites opened
 *     - student   isFull(9, 9) = true
 *     - reference isFull(9, 9) = false
 *     - failed on trial 1 of 5
 *
 *   * n = 20
 *     - isFull() returns wrong value after 241 sites opened
 *     - student   isFull(11, 19) = true
 *     - reference isFull(11, 19) = false
 *     - failed on trial 1 of 2
 *
 *   * n = 50
 *     - isFull() returns wrong value after 1488 sites opened
 *     - student   isFull(43, 38) = true
 *     - reference isFull(43, 38) = false
 *     - failed on trial 1 of 1
 *
 * ==> FAILED
 *
 *
 * Total: 12/15 tests passed!
 *
 *
 * ================================================================
 * ********************************************************************************
 * *  TESTING CORRECTNESS (substituting reference Percolation)
 * ********************************************************************************
 *
 * Testing correctness of PercolationStats
 * *-----------------------------------------------------------
 * Running 15 total tests.
 *
 * Test 1: check that methods in PercolationStats do not print to standard output
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 2: check that mean() returns value in expected range
 *   * n =   2, trials = 10000
 *   * n =   5, trials = 10000
 *   * n =  10, trials = 10000
 *   * n =  25, trials = 10000
 * ==> passed
 *
 * Test 3: check that stddev() returns value in expected range
 *   * n =   2, trials = 10000
 *   * n =   5, trials = 10000
 *   * n =  10, trials = 10000
 *   * n =  25, trials = 10000
 * ==> passed
 *
 * Test 4: check that PercolationStats creates trials Percolation objects, each of size n-by-n
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 5: check that PercolationStats calls open() until system percolates
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 6: check that PercolationStats does not call open() after system percolates
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 7: check that mean() is consistent with the number of intercepted calls to open()
 *         on blocked sites
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 8: check that stddev() is consistent with the number of intercepted calls to open()
 *         on blocked sites
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 9: check that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
 *   * n =  20, trials =  10
 *     - PercolationStats confidence low  = 0.5893640125068745
 *     - PercolationStats confidence high = 0.6241359874931253
 *     - PercolationStats mean            = 0.6067499999999999
 *     - PercolationStats stddev          = 0.03966964274549944
 *     - T                                = 10
 *     - student T                        = 10
 *     - mean - 1.96 * stddev / sqrt(T)   = 0.5821625006919731
 *     - mean + 1.96 * stddev / sqrt(T)   = 0.6313374993080267
 *
 *   * n =  50, trials =  20
 *     - PercolationStats confidence low  = 0.5832168841365849
 *     - PercolationStats confidence high = 0.5997031158634148
 *     - PercolationStats mean            = 0.5914599999999999
 *     - PercolationStats stddev          = 0.02973858737309773
 *     - T                                = 20
 *     - student T                        = 20
 *     - mean - 1.96 * stddev / sqrt(T)   = 0.5784264894274714
 *     - mean + 1.96 * stddev / sqrt(T)   = 0.6044935105725283
 *
 *   * n = 100, trials =  50
 *     - PercolationStats confidence low  = 0.5901824063144403
 *     - PercolationStats confidence high = 0.5950215936855596
 *     - PercolationStats mean            = 0.592602
 *     - PercolationStats stddev          = 0.012344865742651147
 *     - T                                = 50
 *     - student T                        = 50
 *     - mean - 1.96 * stddev / sqrt(T)   = 0.5891801777944492
 *     - mean + 1.96 * stddev / sqrt(T)   = 0.5960238222055507
 *
 *   * n =  64, trials = 150
 *     - PercolationStats confidence low  = 0.5839680103084491
 *     - PercolationStats confidence high = 0.5949121980248843
 *     - PercolationStats mean            = 0.5894401041666667
 *     - PercolationStats stddev          = 0.0223350769723164
 *     - T                                = 150
 *     - student T                        = 150
 *     - mean - 1.96 * stddev / sqrt(T)   = 0.5858657474260666
 *     - mean + 1.96 * stddev / sqrt(T)   = 0.5930144609072668
 *
 * ==> FAILED
 *
 * Test 10: check that exception is thrown if either n or trials is out of bounds
 *   * n = -23, trials =  42
 *   * n =  23, trials =   0
 *   * n = -42, trials =   0
 *   * n =  42, trials =  -1
 *   * n = -2147483648, trials = -2147483648
 * ==> passed
 *
 * Test 11: create two PercolationStats objects at the same time and check mean()
 *          (to make sure you didn't store data in static variables)
 *   * n1 =  50, trials1 =  10, n2 =  50, trials2 =   5
 *   * n1 =  50, trials1 =   5, n2 =  50, trials2 =  10
 *   * n1 =  50, trials1 =  10, n2 =  25, trials2 =  10
 *   * n1 =  25, trials1 =  10, n2 =  50, trials2 =  10
 *   * n1 =  50, trials1 =  10, n2 =  15, trials2 = 100
 *   * n1 =  15, trials1 = 100, n2 =  50, trials2 =  10
 * ==> passed
 *
 * Test 12: check that the methods return the same value, regardless of
 *          the order in which they are called
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 13: check that no calls to StdRandom.setSeed()
 *   * n = 20, trials = 10
 *   * n = 20, trials = 10
 *   * n = 40, trials = 10
 *   * n = 80, trials = 10
 * ==> passed
 *
 * Test 14: check distribution of number of sites opened until percolation
 *   * n = 2, trials = 100000
 *   * n = 3, trials = 100000
 *   * n = 4, trials = 100000
 * ==> passed
 *
 * Test 15: check that each site is opened the expected number of times
 *   * n = 2, trials = 100000
 *   * n = 3, trials = 100000
 *   * n = 4, trials = 100000
 * ==> passed
 *
 *
 * Total: 14/15 tests passed!
 *
 *
 * ================================================================
 * ********************************************************************************
 * *  MEMORY (substituting reference Percolation)
 * ********************************************************************************
 *
 * Analyzing memory of PercolationStats
 * *-----------------------------------------------------------
 * Running 4 total tests.
 *
 * Test 1a-1d: check memory usage as a function of T trials for n = 100
 *             (max allowed: 8*T + 128 bytes)
 *
 *                  T        bytes
 * --------------------------------------------
 * => passed       16          216
 * => passed       32          344
 * => passed       64          600
 * => passed      128         1112
 * ==> 4/4 tests passed
 *
 *
 * Estimated student memory = 8.00 T + 88.00   (R^2 = 1.000)
 *
 * Total: 4/4 tests passed!
 *
 * ================================================================
 *
 *
 *
 * ********************************************************************************
 * *  TIMING (substituting reference Percolation)
 * ********************************************************************************
 *
 * Timing PercolationStats
 * *-----------------------------------------------------------
 * Running 4 total tests.
 *
 * Test 1: count calls to StdStats.mean() and StdStats.stddev()
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 2: count calls to methods in StdRandom
 *   * n = 20, trials = 10
 *   * n = 20, trials = 10
 *   * n = 40, trials = 10
 *   * n = 80, trials = 10
 * ==> passed
 *
 * Test 3: count calls to methods in Percolation
 *   * n =  20, trials =  10
 *   * n =  50, trials =  20
 *   * n = 100, trials =  50
 *   * n =  64, trials = 150
 * ==> passed
 *
 * Test 4: Call PercolationStats methods with trials = 3 and values of n that go up
 *         by a factor of sqrt(2). The test passes when n reaches 2,896.
 *
 *      The approximate order-of-growth is n ^ (log ratio)
 *
 *          n  seconds log ratio
 *      ------------------------
 *        724     0.21       2.4
 *       1024     0.52       2.6
 *       1448     1.33       2.7
 *       2048     3.34       2.6
 *       2896     8.13       2.6
 * ==> passed
 *
 *
 * Total: 4/4 tests passed!
 *
 *
 * ================================================================
 *
 *
 *
 * ********************************************************************************
 * *  MEMORY
 * ********************************************************************************
 *
 * Analyzing memory of Percolation
 * *-----------------------------------------------------------
 * Running 4 total tests.
 *
 * Test 1a-1d: check that total memory <= 17 n^2 + 128 n + 1024 bytes
 *
 *                  n        bytes
 * --------------------------------------------
 * => passed       64        39088
 * => passed      256       598192
 * => passed      512      2375856
 * => passed     1024      9470128
 * ==> 4/4 tests passed
 *
 *
 * Estimated student memory = 9.00 n^2 + 32.00 n + 176.00   (R^2 = 1.000)
 *
 *
 * Test 2 (bonus): check that total memory <= 11 n^2 + 128 n + 1024 bytes
 *    -  bonus available only if solution passes backwash correctness test
 * ==> FAILED
 *
 *
 * Total: 4/4 tests passed!
 *
 * ================================================================
 *
 *
 *
 * ********************************************************************************
 * *  TIMING
 * ********************************************************************************
 *
 * Timing Percolation
 * *-----------------------------------------------------------
 * Running 16 total tests.
 *
 * Test 1a-1e: Creates an n-by-n percolation system; open sites at random until
 *             the system percolates, interleaving calls to percolates() and open().
 *             Count calls to connected(), union() and find().
 *
 *                                        2 * connected()
 *                  n       union()              + find()        constructor
 * -----------------------------------------------------------------------------------
 * => passed       16          153                   280                   1
 * => passed       32          775                  1238                   1
 * => passed       64         2477                  4484                   1
 * => passed      128        11293                 19212                   1
 * => passed      256        44161                 76118                   1
 * => passed      512       187689                313672                   1
 * => passed     1024       738944               1244510                   1
 * ==> 7/7 tests passed
 *
 *
 * If one of the values in the table violates the performance limits
 * the factor by which you failed the test appears in parentheses.
 * For example, (9.6x) in the union() column indicates that it uses
 * 9.6x too many calls.
 *
 *
 * Tests 2a-2f: Check whether the number of calls to union(), connected(), and find()
 *              is a constant per call to open(), isOpen(), isFull(), and percolates().
 *              The table shows the maximum number of union(), connected(), and
 *              find() calls made during a single call to open(), isOpen(), isFull(),
 *              and percolates().
 *
 *                  n     per open()      per isOpen()    per isFull()    per percolates()
 * ---------------------------------------------------------------------------------------------
 * => passed       16        4               0               1               1
 * => passed       32        4               0               1               1
 * => passed       64        4               0               1               1
 * => passed      128        4               0               1               1
 * => passed      256        4               0               1               1
 * => passed      512        4               0               1               1
 * => passed     1024        4               0               1               1
 * ==> 7/7 tests passed
 *
 *
 *
 * Running time (in seconds) depends on the machine on which the script runs.
 *
 *
 * Test 3: Create an n-by-n percolation system; interleave calls to percolates()
 *         and open() until the system percolates. The values of n go up by a
 *         factor of sqrt(2). The test is passed if n >= 4096 in under 10 seconds.
 *
 *      The approximate order-of-growth is n ^ (log ratio)
 *
 *                         log   union-find     log
 *          n  seconds   ratio   operations   ratio
 *      -------------------------------------------
 *       1024     0.12     2.5      2728778     2.0
 *       1448     0.32     2.8      5403268     2.0
 *       2048     0.89     2.9     10842072     2.0
 *       2896     2.33     2.8     21841708     2.0
 *       4096     5.30     2.4     43410130     2.0
 * ==> passed
 *
 *
 *
 * Test 4: Create an n-by-n percolation system; interleave calls to open(),
 *         percolates(), isOpen(), isFull(), and numberOfOpenSites() until.
 *         the system percolates. The values of n go up by a factor of sqrt(2).
 *         The test is passed if n >= 4096 in under 10 seconds.
 *
 *                         log   union-find     log
 *          n  seconds   ratio   operations   ratio
 *      -------------------------------------------
 *       1024     0.11     1.9      3964108     2.1
 *       1448     0.28     2.7      7981274     2.0
 *       2048     0.83     3.1     15711308     2.0
 *       2896     2.30     2.9     31619712     2.0
 *       4096     5.55     2.5     63454318     2.0
 * ==> passed
 *
 *
 * Total: 16/16 tests passed!
 *
 *
 * ================================================================
 */
