package p07_generic_swap_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(reader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(reader.readLine());

            Box<Integer> integerBox = new Box<>();
            integerBox.setValue(line);
            boxes.add(integerBox);
        }

        int[] indexes = Arrays
                .stream(reader.readLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        Box.swap(boxes, firstIndex, secondIndex);

        boxes.forEach(System.out::println);
    }
}
