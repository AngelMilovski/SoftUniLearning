import java.util.Scanner;

public class p01_ReadInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstWord = scan.next();
        String secondWord = scan.next();
        int firstNum = scan.nextInt();
        int secondNum = scan.nextInt();
        int thirdNum = scan.nextInt();
        int sum = firstNum + secondNum + thirdNum;
        String thirdWord = scan.next();
        System.out.println((firstWord + " " + secondWord + " " + thirdWord + " " + sum));
    }
}
