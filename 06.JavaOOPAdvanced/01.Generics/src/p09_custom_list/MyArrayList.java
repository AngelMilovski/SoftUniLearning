package p09_custom_list;

import java.util.*;
import java.util.stream.Collectors;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {

    private List<T> myList;

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.myList.size();
    }

    public MyArrayList() {
        this.myList = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.myList.add(element);
    }

    @Override
    public T remove(int index) {
        if (this.isValidIndex(index)) {
            T item = this.myList.remove(index);
            return item;
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.myList.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (this.isValidIndex(firstIndex) && this.isValidIndex(secondIndex)) {
            T itemForFirstIndex = this.myList.get(secondIndex);
            T itemForSecondIndex = this.myList.get(firstIndex);

            this.myList.set(firstIndex, itemForFirstIndex);
            this.myList.set(secondIndex, itemForSecondIndex);
        }
    }

    @Override
    public int countGreaterThan(T element) {

        return myList
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public T getMax() {
        return this.myList.stream().max(Comparator.naturalOrder()).get();
    }

    @Override
    public T getMin() {
        return myList.stream().min((Comparator<? super T>) Comparator.reverseOrder().reversed()).get();
    }

    @Override
    public void sort() {
        Collections.sort(this.myList);
    }

    @Override
    public void foreach() {
        this.myList.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {

        private int count;

        public ListIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return this.count < myList.size();
        }

        @Override
        public T next() {
            return myList.get(this.count++);
        }
    }
}
