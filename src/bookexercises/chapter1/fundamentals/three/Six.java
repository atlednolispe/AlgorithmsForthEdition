package bookexercises.chapter1.fundamentals.three;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * What does the following code fragment do to the queue q?
 * Stack<String> stack = new Stack<String>();
 * while (!q.isEmpty())
 *     stack.push(q.dequeue());
 * while (!stack.isEmpty())
 *     q.enqueue(stack.pop());
 *
 * @author atlednolispe
 * @email atlednolispe@gmail.com
 * @date 2018/7/14
 */
public class Six {
    /**
     * Queue<String> can't be replaced by Queue<Item>
     */
    public static void showQueue(Queue<String> q)
    {
        for (String s: q)
        {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }


    /**
     * reverse the queue q
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Queue<String> q = new Queue<>();

        String[] ss = "0 1 2 3 4".split("\\s");
        for (String s: ss)
        {
            q.enqueue(s);
        }

        StdOut.println("Queue before: ");
        showQueue(q);
        
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

        StdOut.println("Queue after: ");
        showQueue(q);
    }
}

class Queue<Item> implements Iterable<String>{
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item i) {
        Node oldLast = last;
        last = new Node();
        last.item = i;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        /**
         * 默认dequeue操作前非空
         */
        Item result = first.item;
        first = first.next;
        // isEmpty如果用N == 0,last需要不同的处理
        if (isEmpty())
        {
            last = null;
        }
        N--;
        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
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
}
