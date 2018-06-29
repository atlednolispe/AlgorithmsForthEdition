package bookexercises.chapter1.fundamentals.one;

import edu.princeton.cs.algs4.StdOut;

/**
 * Take 3 integer command-line arguments and print equal if all are equal, or not.
 *
 * Notice:
 * Don't judge by args[0].
 * string == string compare their memory address.
 */
public class Three {
    public static void main(String[] args) {
        StdOut.printf("User type in: %d %d %d\n", Integer.parseInt(args[0]),
                Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        boolean judge;
        if (args[0] == args[1])
        {
            if (args[0] == args[2])
            {
                judge = true;
            }
            else
            {
                judge = false;
            }
        }
        else
        {
            judge = false;
        }
        if (judge)
        {
            StdOut.println("These 3 integers are equal.");
        }
        else
        {
            StdOut.println("These 3 integers are not equal.");
        }
    }
}
