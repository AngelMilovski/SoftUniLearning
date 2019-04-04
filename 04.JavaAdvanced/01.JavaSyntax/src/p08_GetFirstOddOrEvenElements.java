import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p08_GetFirstOddOrEvenElements {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] inputNumbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] command = reader.readLine().split("\\s+");
        int neededCountElements = Integer.parseInt(command[1]);
        String typeNumbers = command[2];
        int count = 0;

        switch (typeNumbers) {
            case "odd":
                    for (int i = 0; i < inputNumbers.length; i++) {
                    if (count == neededCountElements) {
                        System.out.println();
                        return;
                    }
                        int currentNum = inputNumbers[i];
                        if (currentNum % 2 != 0) {
                            System.out.print(currentNum + " ");
                            count++;
                        }
                    }
                break;
            case "even":
                for (int i = 0; i < inputNumbers.length; i++) {
                    if (count == neededCountElements) {
                        System.out.println();
                        return;
                    }
                    int currentNum = inputNumbers[i];
                    if (currentNum % 2 == 0) {
                        System.out.print(currentNum + " ");
                        count++;
                    }
                }
                break;
        }
        System.out.println();
    }
}