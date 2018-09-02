package p02_array_creator;

import java.lang.reflect.Array;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T element) {

        T[] array = (T[]) new Object[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = element;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T element) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < array.length; i++) {
           array[i] = element;
        }
        return array;
    }
}
