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

    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            last = first;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            oldFirst.prev = first;
            first.next = oldFirst;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
        }
        else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            last.prev = oldLast;
            oldLast.next = last;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        Item item = first.item;
        if (size() == 1) {
//            first = new Node();
            first = null;
            last = first;
        }
        else {
            first = first.next;
            first.prev = null;
        }
        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        Item item = last.item;
        if (size() == 1) {
            last = null;
            first = null;
        }
        else {
            last = last.prev;
            last.next = null;
        }

        n--;
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
            return (current != null);
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

        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        Iterator<Integer> it = deque.iterator();  //    ==> [1]
        StdOut.println(it.hasNext());
        StdOut.println(it.next());
        deque.removeLast(); //  ==> 1
        it = deque.iterator();    //==> [null]
        StdOut.println(it.hasNext());
        StdOut.println(it.next());

        deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.removeLast();
        deque.removeLast();
        StdOut.println(deque.isEmpty());

        deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
        StdOut.println(deque.isEmpty());

        deque = new Deque<>();
        deque.addLast(1);
        deque.removeLast();
        deque.addLast(3);
        deque.removeLast();
        StdOut.println(deque.isEmpty());

        deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        deque.addLast(3);
        deque.removeLast();
        StdOut.println(deque.isEmpty());

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

        for (int i = 0; i < 5; i++) {
            int res = mydeq.removeLast();
            StdOut.println(res);
            res = mydeq.removeFirst();
            StdOut.println(res);
        }


    }

}
