package p02_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        MyStack<Integer> numbers = new MyStack<>();

        for (String line = reader.readLine(); !"END".equals(line); line = reader.readLine()) {
            String[] commandArgs = line.replace(",", "").split("\\s+");

            switch (commandArgs[0]) {
                case "Push":
                    int[] numbersElements = Arrays.stream(commandArgs).skip(1).mapToInt(Integer::parseInt).toArray();
                    for (int numbersElement : numbersElements) {
                        numbers.push(numbersElement);
                    }
                    break;
                case "Pop":
                    try {
                        numbers.pop();
                    } catch (ArrayIndexOutOfBoundsException aioobe) {
                        System.out.println(aioobe.getMessage());
                    }

                    break;
            }
        }

        print(numbers);
        print(numbers);

    }

    private static void print(MyStack<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
