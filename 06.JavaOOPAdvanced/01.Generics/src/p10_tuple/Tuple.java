package p10_tuple;

import javafx.util.Pair;

public class Tuple<K, V> extends Pair<K, V> {

    public Tuple(K key, V value) {
        super(key, value);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",super.getKey(), super.getValue());
    }
}
