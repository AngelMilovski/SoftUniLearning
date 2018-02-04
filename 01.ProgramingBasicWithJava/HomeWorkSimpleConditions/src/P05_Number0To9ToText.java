import java.util.Scanner;

public class P05_Number0To9ToText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String result = "";
        if (num > 10){
            System.out.println("number too big");
        }
        else if (num <=9){
            result = ones[num];
        }
        System.out.println(result);
    }
}
