import java.util.Scanner;

public class p02_AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int sum = firstNumber + secondNumber;

        System.out.println(String.format("%s + %s = %s", firstNumber, secondNumber, sum));
    }
}
