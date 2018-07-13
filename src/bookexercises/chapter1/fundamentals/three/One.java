package bookexercises.chapter1.fundamentals.three;

/**
 * Add a method isFull() to FixedCapacityStackOfStrings.
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/13
 */
public class One {
}

class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String s) {
        a[N++] = s;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isFull() {
        return N == a.length;
    }
}