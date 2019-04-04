import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.*;

public class p06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int divider = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> divisible = (n, n1) -> n % n1 == 0;
        BiFunction<int[], Integer, int[]> func = (nums, n) -> {
            int[] newArr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[nums.length - 1 - i];
                if (divisible.test(num, divider)) {
                    continue;
                } else {
                    newArr[i] = num;
                }
            }
            return newArr;
        };
        numbers = func.apply(numbers, divider);
        StringBuilder sb = new StringBuilder();
        Consumer<int[]> print = (nums) -> {
            for (int num : nums) {
                if (num != 0) {
                    sb.append(num).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        };
        print.accept(numbers);
    }
}
