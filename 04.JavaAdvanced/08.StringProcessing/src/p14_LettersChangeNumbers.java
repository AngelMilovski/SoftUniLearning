import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class p14_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<Character, Double> letters = getLettersPosition();
        String[] input = reader.readLine().split("\\s+");
        double totalSum = 0.0d;
        for (String numbersAndLetter : input) {
            char beforeNum = numbersAndLetter.charAt(0);
            char afterNum = numbersAndLetter.charAt(numbersAndLetter.length() - 1);
            double sum = Double.parseDouble(numbersAndLetter.substring(1, numbersAndLetter.length() - 1));
            if (Character.isUpperCase(beforeNum)) {
//                divide
                char charBeforeNum = Character.toLowerCase(beforeNum);
                double divider = letters.get(charBeforeNum);
                sum /= divider;

            } else if (Character.isLowerCase(beforeNum)) {
//                multiply
                double multiplier = letters.get(beforeNum);
                sum *= multiplier;
            }
            if (Character.isUpperCase(afterNum)) {
//                subtract
                char charAfterNum = Character.toLowerCase(afterNum);
                double subtrahend = letters.get(charAfterNum);
                sum -= subtrahend;

            } else if (Character.isLowerCase(afterNum)) {
//                add
                double addend = letters.get(afterNum);
                sum += addend;
            }
            totalSum += sum;
        }
        System.out.println(String.format("%.2f", totalSum));
    }

    private static Map<Character, Double> getLettersPosition() {
        Map<Character, Double> letters = new TreeMap<>();
        double count = 0.0d;
        for (int i = 'a'; i <= 'z'; i++) {
            count++;
            letters.put((char) i, count);

        }
        return letters;
    }
}
