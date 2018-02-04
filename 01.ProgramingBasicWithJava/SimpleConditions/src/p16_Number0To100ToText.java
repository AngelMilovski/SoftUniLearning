import java.util.Scanner;

public class p16_Number0To100ToText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer number = Integer.parseInt(scan.nextLine());
        String[] elevenToFifteen = {"", "eleven", "twelve", "thirteen", "", "fifteen"};
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
                "one hundred"};

        String result = "";
        int position;
        if (number < 0 || number > 100) {
            result = "invalid number";
        } else if (number <= 9) {
            result = ones[number];
        } else if (number % 10 == 0) {
            position = number / 10;
            result = tens[position - 1];
        } else if (number <= 19) {
            position = number % 10;
            result = number <= 13 || number == 15 ? elevenToFifteen[position ] : ones[position] + "teen";
        } else {
            int first = number / 10;
            int second = number % 10;
            result = tens[first] + " " + ones[second];
        }

        System.out.println(result);
    }
}
