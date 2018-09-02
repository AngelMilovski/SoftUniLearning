package p02_stack_iterator;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 16;

    private int countOfElements;

    private T[] head;

    private int capacity;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.capacity = INITIAL_CAPACITY;
        this.countOfElements = 0;
        this.head = (T[]) new Object[this.capacity];
    }

    private void grow() {
        this.capacity *= 2;
        this.head = Arrays.copyOf(this.head, this.capacity);
    }

    private boolean isFull() {
        return this.countOfElements >= this.capacity - 1;
    }

    public boolean isEmpty() {
        return this.countOfElements == 0;
    }

    public void push(T element) {
        if (isFull()) {
            grow();
        }
        this.head[this.countOfElements++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw  new ArrayIndexOutOfBoundsException("No elements");
        }

        T oldElement = this.head[--this.countOfElements];
        this.head[this.countOfElements] = null;

        return oldElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        private int count;

        public StackIterator() {
            this.count = countOfElements;
        }

        @Override
        public boolean hasNext() {
            return this.count != 0;
        }

        @Override
        public T next() {
            return head[--count];
        }
    }
}
