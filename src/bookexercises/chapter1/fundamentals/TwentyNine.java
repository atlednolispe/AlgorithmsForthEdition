package bookexercises.chapter1.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Equal keys. Add to BinarySearch a static method rank() that takes a key and
 * a sorted array of int values(some of which may be equal) as arguments and returns the
 * number of elements that are smaller than the key and a similar method count() that
 * returns the number of elements equal to the key. Note: If i and j are the values retured
 * by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
 * the array that are equal to key.
 *
 * My solution is so ugly, later to find a better one.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/3/31
 */
public class TwentyNine {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        int numberCount = 0;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
            {
                hi = mid - 1;
            }
            else if (key > a[mid])
            {
                lo = mid + 1;
            }
            else
            {
                /**
                 * Find the key in the array, then to find the smallest index of the key. If the index == 0, the return
                 * 0, else return the index.
                 */
                numberCount = mid;
                for (int j = numberCount - 1; j != -1; --j)
                {
                    if (a[j] != key)
                    {
                        numberCount = j + 1;
                        return numberCount;
                    }
                }
                numberCount = 0;
                return numberCount;
            }
        }
        /**
         * Can't find the key in the array. If key < a[0], then lo = 0, else if key > a[a.length -1],
         * then hi = a.length -1, or key is between two numbers in the array.
         */
        if (lo == 0)
        {
            numberCount = 0;
        }
        else if (hi == a.length - 1)
        {
            numberCount = a.length;
        }
        else
        {
            numberCount = lo;
        }
        return numberCount;
    }

    public static int count(int key, int[] a)
    {
        int r = rank(key, a);
        if (r == a.length || a[r] != key)
        {
            return 0;
        }
        else
        {
            for (int j = r + 1; j != a.length; ++j)
            {
                if (a[j] != key)
                {
                    return j - r;
                }
            }
            return a.length - r;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 3, 3, 3};
        int[] rankArray = new int[5];
        int[] countArray = new int[5];

        for (int i = 0; i != 5; ++i)
        {
            rankArray[i] = rank(i, array);
            countArray[i] = count(i, array);
            StdOut.println("The count of number is smaller than " + i +" is " + rankArray[i] + ".");
            StdOut.println("The count of number is equal to " + i +" is " + countArray[i] + ".");
        }
    }
}
