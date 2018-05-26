

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class p09_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(input[0]);
        int numberOfElementsToPop = Integer.parseInt(input[1]);
        int numberToCompare = Integer.parseInt(input[2]);
        String[] data = reader.readLine().split("\\s+");
        int[] numbers = new int[data.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numberOfElementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.poll();
        }
        if (stack.contains(numberToCompare)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        }
        else {
            System.out.println(Collections.min(stack));
        }
    }
}
