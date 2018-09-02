package p08_generic_count_method;

import java.util.List;
import java.util.stream.Collectors;

public class ComparableBox<T extends Comparable<T>> implements Comparable<ComparableBox<T>> {
    private T value;

    public ComparableBox() { }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }

    @Override
    public int compareTo(ComparableBox<T> other) {
        return this.value.compareTo(other.value);
    }

    public static <T extends Comparable<T>> int getCountOfGreaterElements(List<ComparableBox<T>> boxes, ComparableBox<T> box) {
        return boxes.stream()
                .filter((b) -> b.compareTo(box) > 0)
                .collect(Collectors.toList())
                .size();
    }
}
