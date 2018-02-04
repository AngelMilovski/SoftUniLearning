import java.util.Scanner;

public class DigitOrVowel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();
        String result = "";

        if (input.equals("a") || input.equals("e") || input.equals("i") || input.equals("o") || input.equals("u") || input.equals("y")) {
            result = "vowel";
        } else if (input.equals("b") || input.equals("c") || input.equals("d") || input.equals("f") || input.equals("g")
                || input.equals("h") || input.equals("j") || input.equals("k") || input.equals("l") || input.equals("m")
                || input.equals("input") || input.equals("p") || input.equals("q") || input.equals("r") || input.equals("s")
                || input.equals("t") || input.equals("v") || input.equals("w") || input.equals("x") || input.equals("z")) {
            result = "other";
        } else {
            result = "digit";
        }
        System.out.println(result);
    }
}
