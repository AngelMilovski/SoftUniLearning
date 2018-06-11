import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class p05_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        String command;

        while (true) {
            if ("end".equals(command = reader.readLine())) {
                break;
            }

            switch (command) {
                case "add":
                    Function<int[], int[]> add = (nums) -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] += 1;
                        }
                        return numbers;
                    };
                    add.apply(numbers);
                    break;
                case "subtract":
                    Function<int[], int[]> subs = (nums) -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] -= 1;
                        }
                        return numbers;
                    };
                    subs.apply(numbers);
                    break;
                case "multiply":
                    Function<int[], int[]> multi = (nums) -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] *= 2;
                        }
                        return numbers;
                    };
                    multi.apply(numbers);
                    break;
                case "divide":
                    Function<int[], int[]> div = (nums) -> {
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] /= 2;
                        }
                        return numbers;
                    };
                    div.apply(numbers);
                    break;
                default:
                    Consumer<int[]> print = (n) -> {
                        StringBuilder sb = new StringBuilder();
                        for (int number : numbers) {
                            sb.append(number).append(" ");
                        }
                        System.out.println(sb.toString().trim());
                    };
                    print.accept(numbers);
                    break;
            }
        }
    }
}
