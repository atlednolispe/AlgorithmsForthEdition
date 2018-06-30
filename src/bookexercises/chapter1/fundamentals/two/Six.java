package bookexercises.chapter1.fundamentals.two;

import edu.princeton.cs.algs4.StdOut;

/**
 * A string s is a circular rotation of a string t if it matches when the characters
 * are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
 * TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
 * sequences. Write a program that checks whether two given strings s and t are circular
 * shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
 * string concatenation.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/6/30
 */
public class Six {
    public static boolean circularRotationJudge(String s, String t)
    {
        int length = s.length();
        if (length != t.length())
        {
            return false;
        }

        String rotatedS;
        int index = s.indexOf(t.charAt(0));
        while (index != -1)
        {
            rotatedS = s.substring(index, length).concat(s.substring(0, index));
            // rotatedS == t: compared the pointer not the value
            if (rotatedS.equals(t))
            {
                return true;
            }

            index = s.indexOf(t.charAt(0), index+1);
        }

        return false;
    }

    public static boolean circularRotationJudgeInOneLine(String s, String t)
    {
        if (s.length() == t.length() && s.concat(s).indexOf(t) != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";

        boolean ifCircularRotation = circularRotationJudgeInOneLine(s, t);
        if (ifCircularRotation)
        {
            StdOut.println(s + " is a circular rotation of " + t);
        }
        else
        {
            StdOut.println(s + " isn't a circular rotation of " + t);
        }
    }
}
