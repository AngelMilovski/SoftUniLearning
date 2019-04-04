import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class p03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> func = (num) -> {
          int minValue = num[0];
            for (int i = 1; i < num.length; i++) {
                if (num[i] < minValue) {
                    minValue = num[i];
                }
            }
            return minValue;
        };
        int number = func.apply(numbers);
        Consumer<Integer> print = (num) -> {
            System.out.println(num);
        };
        print.accept(number);
    }
}