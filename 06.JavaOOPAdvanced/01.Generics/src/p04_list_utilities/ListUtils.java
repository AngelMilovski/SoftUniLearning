package p04_list_utilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    @SuppressWarnings("unchecked")
    public static <E extends Comparable> E getMax(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        E maxElement = list.get(0);
        int countElements = list.size();
        for (int i = 1; i < countElements; i++) {
            E element = list.get(i);
            if (maxElement.compareTo(list.get(i)) < 0) {
                maxElement = list.get(i);
            }
        }
        return maxElement;
    }

    @SuppressWarnings("unchecked")
    public static <E extends Comparable> E getMin(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int countElements = list.size();
        E minElement = list.get(0);

        for (int i = 1; i < countElements; i++) {
             if (minElement.compareTo(list.get(i)) > 0) {
                 minElement = list.get(i);
             }
        }
        return minElement;
    }

    public static List<Integer> getNullIndices(List<?> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Integer> nulls = new ArrayList<>();

        int index = 0;
        for (Object o : list) {
            if (o == null) {
                nulls.add(index);
            }
            index++;
        }

        return  nulls;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src) {
        for (List<? extends T> inner : src) {
            dest.addAll(inner);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
