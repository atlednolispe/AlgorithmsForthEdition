package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Give the contents and size of the array for DoublingStackOfStrings with the
 * input
 * it was - the best - of times - - - it was - the - -
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/15
 */
public class Eight {
    public static void main(String[] args) {
        DoublingStackOfStrings<String> stack = new DoublingStackOfStrings<>();
        String[] inputs = "it was - the best - of times - - - it was - the - -".split("\\s");
        for (String input: inputs)
        {
            if (input.equals("-"))
            {
                stack.pop();
            }
            else
            {
                stack.push(input);
            }
        }

        for (String i: stack)
        {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}

class DoublingStackOfStrings<Item> implements Iterable<Item> {
    private Item[] array = (Item[]) new Object[1];
    private int N = 0;

    public void push(Item item) {
        if (N == array.length)
        {
            resize(2*N);
        }
        array[N++] = item;
    }

    public Item pop() {
        Item result = array[--N];
        if (N > 0 && N == array.length / 4)
        {
            resize(array.length / 2);
        }
        array[N] = null;
        return result;
    }

    public void resize(int len) {
        Item[] newArray = (Item[]) new Object[len];
        for (int i = 0; i != N; ++i)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * return Iterator<Item>
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    /**
     * ArrayIterator can't be ArrayIterator<Item>!!!
     */
    private class ArrayIterator implements Iterator<Item> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public Item next() {
            return array[index++];
        }

        @Override
        public void remove() {}
    }
}