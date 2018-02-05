import java.util.Scanner;

public class p07_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        String firstStr = input[0];
        String secondStr = input[1];
        int reminder = Math.abs(firstStr.length() - secondStr.length());
        int iterations = Math.min(firstStr.length(), secondStr.length());
        int sum = 0;

        for (int i = 0; i < iterations; i++) {
            char first = firstStr.charAt(i);
            char second = secondStr.charAt(i);
            sum += first * second;
        }
        if (firstStr.length() > secondStr.length()) {

            for (int i = 0; i < reminder; i++) {
                int index = (firstStr.length() - 1 - i) % firstStr.length();
                char currentCh = firstStr.charAt(index);
                sum += currentCh;
            }
        } else if (secondStr.length() > firstStr.length()) {
            for (int i = 0; i < reminder; i++) {
                int index = (secondStr.length() - 1 - i) % secondStr.length();
                char currentCh = secondStr.charAt(index);
                sum += currentCh;
            }
        }
        System.out.println(sum);
    }
}