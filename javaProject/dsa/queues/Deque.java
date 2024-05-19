import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node previous;

    }

    // construct an empty deque
    public Deque(){
        Node first = new Node();
        Node last = first;
        Node previous = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size(){
        return n;
    }

    // add the item to the front
    public void addFirst(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        oldFirst.previous = first;
        if (isEmpty()) first = last;
        n++;
    }

    // add the item to the back
    public void addLast(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        n--;
        Item item = first.item;
        first = first.next;
        first.previous = null;
        if (isEmpty()) last = null;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        n--;
        Item item = last.item;
        last = last.previous;
        last.next = null;
        if (isEmpty()) last = null;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return null;
    }

    // unit testing (required)
    public static void main(String[] args){}

}
