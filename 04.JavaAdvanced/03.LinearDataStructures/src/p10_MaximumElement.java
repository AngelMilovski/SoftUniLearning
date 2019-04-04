import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p10_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int numberOfCommands = Integer.parseInt(reader.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int maxNumber = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = reader.readLine().split(" ");
            String typeOfCommand = command[0];
            switch (typeOfCommand) {
                case "1":
                    int currentElement = Integer.parseInt(command[1]);
                    stack.push(currentElement);
                    if (maxNumber < currentElement) {
                        maxNumber = currentElement;
                    }
                    break;
                case "2":
                    if (maxNumber == stack.pop()) {
                        maxNumber = Integer.MIN_VALUE;
                    }
                    break;
                case "3":
                    if (maxNumber == Integer.MIN_VALUE) {
                        for (Integer number : stack) {
                            if (number >= maxNumber) {
                                maxNumber = number;
                            }
                        }
                    }
                    sb.append(maxNumber).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}