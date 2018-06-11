import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p08_SmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> func = (num) -> {
            int index = 0;
            int minValue = num[0];
            for (int i = 1; i < num.length; i++) {
                if (num[i] <= minValue) {
                    minValue = num[i];
                    index = i;
                }
            }
            return index;
        };
        int number = func.apply(numbers);
        System.out.println(number);
    }
}