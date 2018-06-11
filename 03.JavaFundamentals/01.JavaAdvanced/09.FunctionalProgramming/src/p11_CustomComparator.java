import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p11_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
       String[] input = reader.readLine().split("\\s+");
       Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Comparator<Integer> intComparator = (first, second) -> {
            boolean firstIsEven = first % 2 == 0;
            boolean secondIsEven = second % 2 == 0;
            if (firstIsEven && !secondIsEven) {
                return -1;
            } else if(!firstIsEven && secondIsEven) {
                return 1;
            } else {
                return first - second;
            }
        };
        Arrays.sort(numbers, intComparator);
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number + " ");
        }
        System.out.println(sb.toString().trim());
    }
}