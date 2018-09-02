package p03_scale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int compared = compare(this.left, this.right);
        if (compared < 0) {
            return this.right;
        } else if (compared > 0) {
            return this.left;
        } else {
            return null;
        }
    }

    private int compare(T left, T right) {
        return left.compareTo(right);
    }
}
