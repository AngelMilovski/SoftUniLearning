import java.util.Scanner;

public class p04_CalculateExpression {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        double F1 = f1(a, b, c);
        double F2 = f2(a, b, c);
        double diff = Math.abs(((a + b + c) / 3) - ((F1 + F2) / 2));

        System.out.println(String.format("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", F1, F2, diff));
    }

    private static double f2(double a, double b, double c) {
        double sumNumbers = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3));
        return Math.pow(sumNumbers, (a - b));
    }

    private static double getF1Pow(double a, double b, double c) {
        return ((a + b + c) / Math.sqrt(c));
    }

    private static double f1(double a, double b, double c) {
        double pow = getF1Pow(a, b, c);
        double numbersSum = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
        double result = Math.pow(numbersSum, pow);
        return result;

    }
}