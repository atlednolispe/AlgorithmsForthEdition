package bookexercises.chapter1.fundamentals.three;

import java.util.Iterator;

/**
 * Add a method peek() to Stack that returns the most recently inserted item on
 * the stack (without popping it).
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/14
 */
public class Seven {
}

class PeekStack<Item> implements Iterable<Item> {
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

    public Item peek() {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

}
