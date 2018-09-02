package p07_generic_swap_method;

import java.util.List;

class Box<T extends Comparable<T>>  {
    private T value;

    public Box() { }

    public void setValue(T value) {
        this.value = value;
    }

    public static <T extends Comparable<T>> void swap(List<Box<T >> boxes, int firstIndex, int secondIndex) {
        if (boxes.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }

}
