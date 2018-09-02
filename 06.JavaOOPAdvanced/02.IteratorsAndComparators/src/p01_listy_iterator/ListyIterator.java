package p01_listy_iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListyIterator<T> implements Iterable<T> {

    private T[] items;
    private int index;


    public ListyIterator(T... strings) {
        this.items = strings;
    }

    public void create(T... items) {
        this.items = items;
    }

    public boolean move() {
        if (this.iterator().hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.items.length == 0 || this.index >= this.items.length) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.items[index]);
    }

    public void printAll() {
        for (T item : this.items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {

        private ListIterator() {
        }

        @Override
        public boolean hasNext() {
            return index < items.length - 1;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }
}
