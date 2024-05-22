import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

   private static final int INIT_CAPACITY = 8;

   private Item[] a; //array of items
    private int n; // number of elements in the queue



    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[INIT_CAPACITY];
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

    private void resize(int capacity) {

        // alternative implementation
         a = java.util.Arrays.copyOf(a, capacity);
    }


    // add the item
    public void enqueue(Item item) {
        if (n == a.length) resize(2*a.length);
        a[n++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        int idx = StdRandom.uniformInt(n);
        Item item = a[idx];

        // swap move item at the end into idx slot
        a[idx] = a[--n];
        a[n] = null;
        if (n <= a.length/4) resize(a.length/2);
        return item;

    }


    // return a random item (but do not remove it)
    public Item sample() {
        int idx = StdRandom.uniformInt(n);
        return a[idx];

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public Item next() {
            return sample();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }

    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(380);
        queue.enqueue(298);
        queue.enqueue(722);
        Iterator<Integer> iterator = queue.iterator();
        StdOut.println(iterator.hasNext());
        StdOut.println(iterator.next());

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
