package p04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private BufferedReader reader;
    private List<Integer> numbers;
    private List<Integer> result;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.numbers = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public final void run() throws IOException {
        this.numbers = Stream.of(this.reader.readLine().split("[\\s,]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(numbers);
        this.result = new ArrayList<>();

        lake.forEach(number -> this.result.add(number));

        System.out.println(this.result
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

    }

    public static void main(String[] args) throws IOException {
        Main starter = new Main();
        starter.run();
    }
}
