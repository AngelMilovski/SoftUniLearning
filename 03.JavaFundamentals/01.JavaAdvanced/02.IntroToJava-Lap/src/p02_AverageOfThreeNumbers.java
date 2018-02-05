import java.util.Scanner;

public class p02_AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double firstNum = scan.nextDouble();
        double secondNum = scan.nextDouble();
        double thirdNum = scan.nextDouble();
        double sum = firstNum + secondNum + thirdNum;

        System.out.printf("%.2f", sum / 3);
    }
}
