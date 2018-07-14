package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;

/**
 * Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced. For ex-
 * ample, your program should print true for [()]{}{[()()]()} and false for [(]).
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/14
 */
public class Four {
    public static boolean parenthesesBalancedCheck(String[] parentheses) {
        Stack<String> stack = new Stack<>();
        for (String parenthese: parentheses) {
            if (parenthese.equals("(") || parenthese.equals("[") || parenthese.equals("{"))
            {
                stack.push(parenthese);
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                String paren = stack.pop();
                if (paren.equals("(") && parenthese.equals(")")) { continue; }
                if (paren.equals("[") && parenthese.equals("]")) { continue; }
                if (paren.equals("{") && parenthese.equals("}")) { continue; }

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // [ ( ) ] { } { [ ( ) ( ) ] ( ) }
        String[] parentheses = "[ ( ] )".split("\\s");

        for (String s: parentheses)
        {
            StdOut.print(s);
        }
        if (parenthesesBalancedCheck(parentheses))
        {
            StdOut.println(" is balanced.");
        }
        else
        {
            StdOut.println(" is not balanced!");
        }
    }
}
