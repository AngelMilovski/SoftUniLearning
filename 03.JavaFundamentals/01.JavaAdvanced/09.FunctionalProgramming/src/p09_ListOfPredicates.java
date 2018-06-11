import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class p09_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        BiPredicate<Integer, int[]> checker = (div1, div2) -> {
            for (int num : div2) {
                if (div1 % num != 0) {
                    return false;
                }
            }
            return true;
        };
        List<Integer> newArr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (checker.test(i, numbers)) {
                newArr.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : newArr) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}