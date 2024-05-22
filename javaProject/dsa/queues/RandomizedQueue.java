import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;

    private Item[] a; // array of items
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
        assert capacity >= n;

        // manual copy to pass the assignment
        // normally would use this instead:
        // a = java.util.Arrays.copyOf(a, capacity);
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;

    }


    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("cannot enqueue null");
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("cannot dequeue from empty");
        int idx = StdRandom.uniformInt(n);
        Item item = a[idx];

        // swap move item at the end into idx slot
        a[idx] = a[--n];
        a[n] = null;
        if (n <= a.length / 4) resize(a.length / 2);
        return item;

    }


    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("cannot sample from empty");
        int idx = StdRandom.uniformInt(n);
        return a[idx];

    }

    private int[] shuffleIdx() {
        int [] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        StdRandom.shuffle(indices);
        return indices;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int k = 0;
        int [] randIdx = shuffleIdx();

        @Override
        public boolean hasNext() {
            return k < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("no more elements to return");
            Item item = a[randIdx[k]];
            k++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }

    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(0);
        queue.enqueue(3);
        queue.enqueue(4);
        Iterator<Integer> iterator = queue.iterator();
        int res;
        while (iterator.hasNext()) {
            res = iterator.next();
            StdOut.println(res);
        }

        queue = new RandomizedQueue<>();
        queue.enqueue(380);
        queue.enqueue(298);
        queue.enqueue(722);
        iterator = queue.iterator();
        StdOut.println(iterator.hasNext());
        StdOut.println(iterator.next());

        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            rq.enqueue(i);
        }

        StdOut.println("sample " + rq.sample());
        StdOut.println("size " + rq.size());

        while (rq.size() > 0) {
            res = rq.dequeue();
            StdOut.println("dequeue " + res);
        }

    }

}
