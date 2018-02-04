import java.util.Scanner;

public class p04_DebitCardNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());
        int fourthNumber = Integer.parseInt(scan.nextLine());

        System.out.printf("%04d %04d %04d %04d%n", firstNumber, secondNumber, thirdNumber, fourthNumber);

    }
}
