import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p14_RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int number = Integer.parseInt(reader.readLine());
        long[] fibonacci = getFibonacci(number);
        System.out.println(Arrays.stream(fibonacci).sum());
        long sum = 0;
        for (int i = 0; i < fibonacci.length; i++) {
            sum += fibonacci[i];
        }
//        long fibonacci = getFibonacciSum(number);
//        System.out.println(fibonacci);
    }

//    private static long getFibonacciSum(int number) {
//        if (number == 0) {
//            return 1;
//        } else if (number < 2) {
//            return 1;
//        } else {
//            return getFibonacciSum(number - 1) + getFibonacciSum(number - 2);
//        }
//    }

    private static long[] getFibonacci(int number) {
        if (number <= 1) {
            long[] answer = {number, 0};
            return answer;
        } else {
            long[] tmp = getFibonacci(number - 1);
            long[] answer = {tmp[0] + tmp[1], tmp[0]};
            return answer;
        }
    }
}