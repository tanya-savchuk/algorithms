import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first, last, current;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;

    }


    // construct an empty randomized queue
    public RandomizedQueue() {
        first = new Node();
        last = first;
        current = first;
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }


    // add the item
    public void enqueue(Item item) {
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

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        int k = StdRandom.uniformInt(n);
        current = advance(k);
        Item item = current.item;
        if (size() == 1) {
            // do nothing;
        }
        else if (current == first) {
            first = current.next;
            first.prev = null;
        }
        else if (current == last) {
            last = current.prev;
            last.next = null;
        }
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        current = null;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    private Node advance(int k) {
        Node cur = first;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        return cur;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("cannot remove item from an empty deque");
        int k = StdRandom.uniformInt(n);
        Node kNode = advance(k);
        return kNode.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null && current.next != null);
        }

        @Override
        public Item next() {
            Node current = first;
            if (!hasNext()) throw new NoSuchElementException("no more items in the deque");
            int k = StdRandom.uniformInt(n);
            Node kNode = advance(k);
            Item item = kNode.item;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }

//        @Override
//        public void forEachRemaining(Consumer<? super Item> action) {
//            Iterator.super.forEachRemaining(action);
//        }
    }

    // unit testing (required)
    public static void main(String[] args){
        int item;
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            rq.enqueue(i);
        }

        StdOut.println("sample " + rq.sample());
        StdOut.println("size " + rq.size());

        while (rq.size() > 0) {
            int res = rq.dequeue();
            StdOut.println("dequeue " + res);
        }

    }

}
