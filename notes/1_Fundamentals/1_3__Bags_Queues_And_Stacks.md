chapter1.3-Bags, Queues, and Stacks
===================================

### 1.3.1 API

#### 1.3.1.1 泛型

```java
//Item为一个类型参数,可以为任意引用类型
class Xxxx<Item>
```

#### 1.3.1.3 可迭代的集合类型

```java
// foreach
Queue<Transaction> collection = new Queue<Transaction>();

for (Transaction t : collection)
{
    StdOut.println(t);
}
```

#### 1.3.1.7 算术表达式求值

```java
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Arithmetic expression evaluation.
 * 
 * Push operands onto the operand stack.
 * Push operators onto the operator stack.
 * Ignore left parentheses.
 * On encountering a right parenthesis, pop an operator, pop the requisite number
 * of operands, and push onto the operand stack the result of applying that opera-
 * tor to those operands.   
 */
public class Evalute {

    public static void main(String[] args) {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] cal = s.split("\\s");

        Stack<String> ops = new Stack<>();
        Stack<Integer> vals = new Stack<>();

        for (String i: cal)
        {
            if (i.equals("("))
            {
                continue;
            }
            if (i.equals("+"))
            {
                ops.push("+");
                continue;
            }
            if (i.equals("-"))
            {
                ops.push("-");
                continue;
            }
            if (i.equals("*"))
            {
                ops.push("*");
                continue;
            }
            if (i.equals("/"))
            {
                ops.push("/");
                continue;
            }

            if (i.equals(")"))
            {
                int v1 = vals.pop();
                String op = ops.pop();

                int value = 0;
                if (op.equals("+"))
                {
                    value = vals.pop() + v1;
                }
                if (op.equals("-"))
                {
                    value = vals.pop() - v1;
                }
                if (op.equals("*"))
                {
                    value = vals.pop() * v1;
                }
                if (op.equals("/"))
                {
                    value = vals.pop() / v1;
                }

                vals.push(value);
                continue;
            }

            vals.push(Integer.parseInt(i));
        }
        StdOut.println(vals.pop());
    }
}
```

### 1.3.2 集合类数据类型的实现

```java
// FixedCapacityStackOfStrings
// String[]


// java不能创建范型数组
// error
Item[] a = new Item[N];

// ok
Item[] a = (Item[]) new Object[N];

public class FixedCapacityStack<Item> {
    private Item[] a;   // stack entries
    private int N;      // size
    
    public FixedCapacityStack(int cap)
    {  
        a = (Item[]) new Object[cap];  
    }
    
    public boolean isEmpty() 
    {  
        return N == 0; 
    }
    
    public int size()
    {  
        return N; 
    }
    
    public void push(Item item)
    {  
        a[N++] = item;
    }
    
    public Item pop()
    {  
        return a[--N]; 
    }
}

// 对数组大小进行适当调整尽量保持在半满的状态附近

// 为了及时的垃圾回收,pop后将数组对象置为null

public class ResizingArrayStack<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int max) {  // Move stack to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item)
    {  // Add item to top of stack.
        if (N == a.length)
        {
            resize(2 * a.length);
        }
        a[N++] = item;
    }
    
    public Item pop()
    {  // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
        {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        /**
         * Support LIFO iteration.
         */
        private int i = N;

        @Override
        public boolean hasNext()
        {
            return i > 0;
        }

        @Override
        public Item next()
        {
            return a[--i];
        }

        @Override
        public void remove() {}
    }
}
```

### 1.3.3 链表

```java
// 实现任意插入和删除操作的标准解决方案是使用双向链表

// 遍历链表
for (Node x = first; x != null; x = x.next)
{
    // Process x.item
}


class Stack<Item> {
    private int N;
    private Node first;
    private class Node {
        Item item;
        Node next;
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
    
    public static void main(String[] args)
    {  
         Stack<String> s = new Stack<String>();
         while (!StdIn.isEmpty())
         {
            String item = StdIn.readString();
            if (!item.equals("-"))
                 s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " "); 
         }
         StdOut.println("(" + s.size() + " left on stack)"); 
    }
}

class Queue<Item> {
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
}

import java.util.Iterator;
class Bag<Item> implements Iterable<Item> {
    private Node first;
    private class Node {
        Item item;
        Node next;
    }

    public void add(Item i) {
        Node oldFirst = first;
        first = new Node();
        first.item = i;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        /**
         * 声明iterator返回的是Iterator<Item>不是ListIterator对象
         */
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
```

### Q&A

```java
// 字符串栈数组
Stack<String>[] a = (Stack<String>[]) new Stack[N]

// 坚持窄接口
narrow interfaces
```