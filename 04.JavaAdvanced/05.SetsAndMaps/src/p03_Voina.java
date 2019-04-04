import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class p03_Voina {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();
        fillNumbers(reader, firstPlayer, secondPlayer);
        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First player win!");
                return;
            }
            int firstNum = firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);
            if (firstNum > secondNum) {
            firstPlayer.add(firstNum);
            firstPlayer.add(secondNum);
            } else if (secondNum > firstNum) {
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }
        }
        printResult(firstPlayer, secondPlayer);
    }

    private static void printResult(LinkedHashSet<Integer> firstPlayer, LinkedHashSet<Integer> secondPlayer) {
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    private static void fillNumbers(BufferedReader reader, LinkedHashSet<Integer> firstPlayer, LinkedHashSet<Integer> secondPlayer) throws IOException {
        int[] firstLine = (Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)).toArray();
        int[] secondLine = (Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)).toArray();

        for (Integer cardNum : firstLine) {
            firstPlayer.add(cardNum);
        }
        for (Integer cardNum : secondLine) {
            secondPlayer.add(cardNum);
        }
    }
}
