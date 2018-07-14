package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/**
 * Suppose that a client performs an intermixed sequence of (stack) push and pop
 * operations. The push operations put the integers 0 through 9 in order onto the stack;
 * the pop operations print out the return values. Which of the following sequence(s)
 * could not occur?
 *
 * a. 4 3 2 1 0 9 8 7 6 5
 * b. 4 6 8 7 5 3 2 9 0 1
 * c. 2 5 6 7 4 8 9 3 1 0
 * d. 4 3 2 1 0 5 6 7 8 9
 * e. 1 2 3 4 5 6 9 8 7 0
 * f. 0 4 6 5 3 8 1 7 2 9
 * g. 1 4 7 9 8 6 5 3 0 2
 * h. 2 1 4 3 6 5 8 7 9 0
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/13
 */
public class Three {
    /**
     * simulate the stack of @param seq, push (n [0, 9]) to stack until the seq[i] = n,
     * then pop, if not equal, push continue, cycle.
     */
    public static boolean check(int[] seq) {
        ShowTopStack<Integer> stack = new ShowTopStack<>();

        int MAX_NUMBER = 10;
        int n = 0;
        int index = 0;

        int[] simulate = new int[MAX_NUMBER];
        int indexOfSimulate = 0;
        StdOut.println("----------simulate start----------");
        while (n < MAX_NUMBER)
        {
            if (stack.isEmpty() || seq[index] != stack.top())
            {
                stack.push(n);
                StdOut.print("> " + n + " ");
                n++;
            }
            else
            {
                int output = (Integer) stack.pop();
                StdOut.print("< " + output + " ");
                simulate[indexOfSimulate++] = output;
                index++;
            }
        }

        for (Object i: stack)
        {
            StdOut.print("< " + i + " ");
            simulate[indexOfSimulate++] = (Integer) i;
        }
        StdOut.println();

        StdOut.print("Simulate: ");
        for (int i: simulate)
        {
            StdOut.print(i + " ");
        }
        StdOut.println();

        StdOut.println("----------simulate end----------");

        for (int i = 0; i != MAX_NUMBER; ++i)
        {
            if (simulate[i] != seq[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /**
         * wrong sequences:
         * {4, 6, 8, 7, 5, 3, 2, 9, 0, 1}
         * {0, 4, 6, 5, 3, 8, 1, 7, 2, 9}
         * {1, 4, 7, 9, 8, 6, 5, 3, 0, 2}
         */
        int[][] sequences = {
                {4, 3, 2, 1, 0, 9, 8, 7, 6, 5},
                {4, 6, 8, 7, 5, 3, 2, 9, 0, 1},
                {2, 5, 6, 7, 4, 8, 9, 3, 1, 0},
                {4, 3, 2, 1, 0, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 9, 8, 7, 0},
                {0, 4, 6, 5, 3, 8, 1, 7, 2, 9},
                {1, 4, 7, 9, 8, 6, 5, 3, 0, 2},
                {2, 1, 4, 3, 6, 5, 8, 7, 9, 0},
        };

        for (int[] seq: sequences)
        {
            if (!check(seq))
            {
                StdOut.print("Wrong sequences: ");
                for (int i: seq)
                {
                    StdOut.print(i + " ");
                }
                StdOut.println();
            }
        }

    }
}

/**
 * Add top method to show the top number of the stack.
 */
class ShowTopStack<Item> extends Stack {
    public Item top() {
        if (!isEmpty())
        {
            Item t = (Item) pop();
            push(t);
            return t;
        }
        return null;
    }
}