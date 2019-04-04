import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class p04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String condition = reader.readLine();

        Predicate<Integer> even = num -> {
            return num % 2 == 0;
        };

        List<Integer> numbers = new ArrayList<>();
        switch (condition) {
            case "even":
                for (int i = bounds[0]; i <= bounds[1]; i++) {
                    if (even.test(i)) {
                        numbers.add(i);
                    }
                }
                break;
            case "odd":
                for (int i = bounds[0]; i <= bounds[1]; i++) {
                    if (!even.test(i)) {
                        numbers.add(i);
                    }
                }
                break;
        }
        Consumer<List<Integer>> print = (n) -> {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : n) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb.toString().trim());
        };
        print.accept(numbers);
    }
}
