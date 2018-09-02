package p04_list_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Engine {
    private List<Integer> integers;
    private List<String> strings;
    private List<Double> doubles;
    private List<List<? extends Number>> jagged;
    private List<Number> dest;


    Engine() {
        this.integers = new ArrayList<>();
        this.strings = new ArrayList<>();
        this.doubles = new ArrayList<>();
        this.jagged = new ArrayList<>();
        this.dest = new ArrayList<>();
    }

    void run() {
        this.integers.clear();
        this.strings.clear();
        Collections.addAll(this.integers, 1, 2, 18, 2, -1);
        Collections.addAll(this.strings, "a", "b", "c");

        int maxInteger = ListUtils.getMax(this.integers);
        String minString = ListUtils.getMin(this.strings);

        ConsoleOutputWriter.writeLine(maxInteger);
        ConsoleOutputWriter.writeLine(minString);

        getIndexOfNullElements();
        getFlatten();
        checkedAddAllMethod();
    }

    private void getIndexOfNullElements() {
        this.integers.clear();
        this.strings.clear();

        this.integers.addAll(new ArrayList<>() {{
            add(1);
            add(2);
            add(null);
            add(2);
            add(null);
        }});
        List<Integer> integerNulls = ListUtils.getNullIndices(this.integers);
        ConsoleOutputWriter.writeLine(integerNulls);

        this.strings.addAll(new ArrayList<>() {{
            add("a");
            add(null);
            add("c");
        }});
        List<Integer> stringNulls = ListUtils.getNullIndices(this.strings);
        ConsoleOutputWriter.writeLine(stringNulls);
    }

    private void getFlatten() {
        this.integers.clear();
        this.doubles.clear();

        Collections.addAll(this.integers, 1, 2, 3);
        Collections.addAll(this.doubles, 1.2, 1.3);
        Collections.addAll(this.jagged, this.integers, this.doubles);
        ListUtils.flatten(this.dest, jagged);
        for (Number number : this.dest) {
            ConsoleOutputWriter.writeLine(number);
        }
    }

    private void checkedAddAllMethod() {
        this.integers.clear();
        this.doubles.clear();
        this.dest.clear();

        Collections.addAll(this.integers, 1, 2, null, 2, null);
        Collections.addAll(this.doubles, 1.2, 3.2, 5.5);
        ListUtils.addAll(this.dest, this.integers);
        ListUtils.addAll(dest, this.doubles);
        for (Number number : this.dest) {
            ConsoleOutputWriter.writeLine(number);
        }
    }
}

