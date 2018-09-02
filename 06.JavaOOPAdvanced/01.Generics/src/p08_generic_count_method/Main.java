package p08_generic_count_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(reader.readLine());

//        List<ComparableBox<String>> boxes = new ArrayList<>();
//
//        while (n-- > 0) {
//            ComparableBox<String> stringComparableBox = new ComparableBox<>();
//            String element = reader.readLine();
//            stringComparableBox.setValue(element);
//            boxes.add(stringComparableBox);
//        }
//
//        ComparableBox<String> box = new ComparableBox<>();
//        String comparableEl = reader.readLine();
//        box.setValue(comparableEl);
//        System.out.println(ComparableBox.getCountOfGreaterElements(boxes, box));

        List<ComparableBox<Double>> boxes = new ArrayList<>();

        while (n-- > 0) {
            ComparableBox<Double> doubleComparableBox = new ComparableBox<>();
            double element = Double.parseDouble(reader.readLine());
            doubleComparableBox.setValue(element);
            boxes.add(doubleComparableBox);
        }

        ComparableBox<Double> box = new ComparableBox<>();
        Double comparableEl = Double.valueOf(reader.readLine());
        box.setValue(comparableEl);
        System.out.println(ComparableBox.getCountOfGreaterElements(boxes, box));
    }
}
