import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;

    }

    // construct an empty deque
    public Deque() {
        first = new Node();
        last = first;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) oldFirst.prev = first;
        if (isEmpty()) first = last;
        n++;
        if (size() == 1) last = first;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        n--;
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        else first.prev = null;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        n--;
        Item item = last.item;
        last = last.prev;
        last.next = null;
        if (isEmpty()) last = null;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {

        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null && current.next != null);
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("no more items in the deque");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }

    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> mydeq = new Deque<Integer>();

        for (int i = 0; i < 5; i++) {
            mydeq.addFirst(i);
        }

        for (int i : mydeq)
            StdOut.println(i);

        for (int i = 0; i < 5; i++) {
            mydeq.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            int res = mydeq.removeFirst();
            StdOut.println(res);
        }

        for (int i = 0; i < 5; i++) {
            mydeq.addFirst(i);
        }

        for (int i = 0; i < 5; i++) {
            mydeq.addLast(i);
        }

        StdOut.println(mydeq.size());

        for (int i = 0; i < 10; i++) {
            mydeq.removeLast();
            int res = mydeq.removeFirst();
            StdOut.println(res);
        }


    }

}
