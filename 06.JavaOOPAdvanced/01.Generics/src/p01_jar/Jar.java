package p01_jar;

import java.util.ArrayDeque;
import java.util.Deque;


public class Jar<E> {
    private Deque<E> contents;


    public Jar() {
        this.contents = new ArrayDeque<>();
    }

    public void add(E element) {
        this.contents.push(element);
    }

    public E remove() {
        return this.contents.poll();
    }

    public void foreach() {
        this.contents.forEach(System.out::println);

    }
}
