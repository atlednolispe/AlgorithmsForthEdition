package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Give the output printed by java Stack for the input
 * it was - the best - of times - - - it  was - the - -
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/13
 */
public class Two {
    public static void main(String[] args)
    {
        Stack<String> s = new Stack<>();

        String[] inputs = {"it", "was", "-", "the", "best", "-", "of", "times", "-", "-", "-", "it", "was", "-", "the", "-", "-"};

        for (String input: inputs)
        {
            if (!input.equals("-"))
            {
                s.push(input);
            }
            else if (!s.isEmpty())
            {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.println("(" + s.size() + " left on stack)");
    }
}

class Stack<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item result = current.item;
            current = current.next;
            return result;
        }

        @Override
        public void remove() {}
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item i) {
        Node oldFirst = first;
        first = new Node();
        first.item = i;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item result = first.item;
        first = first.next;
        N--;
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

}