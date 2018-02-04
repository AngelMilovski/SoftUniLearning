import java.util.Scanner;

public class OperationBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        String sign = scan.nextLine();
        int result = 0;


        switch (sign) {
            case "+":
                if (result % 2 == 0) {
                    System.out.printf("%d + %d = %d - even", num1, num2, result);
                } else {
                    System.out.printf("%d + %d = %d - odd", num1, num2, result);
                }
                break;

            case "-":
                if (sign.equals("-")) {
                    result = num1 - num2;
                    if (result % 2 == 0) {
                        System.out.printf("%d - %d = %d - even", num1, num2, result);
                    } else {
                        System.out.printf("%d - %d = %d - odd", num1, num2, result);
                    }
                    break;
                }

            case "*":
                if (sign.equals("*")) {
                    result = num1 * num2;
                    if (result % 2 == 0) {
                        System.out.printf("%d * %d = %d - even", num1, num2, result);
                    } else {
                        System.out.printf("%d * %d = %d- odd", num1, num2, result);
                    }
                    break;
                }
            case "/":
               double resultDouble = (double) (num1 / num2);
               double n1 = (double)(num1);
               double n2 = (double) (num2);
                if (n2 != 0){
                    System.out.printf("%.0f / %.0f = %.2f", n1, n2, resultDouble);
                }else {
                    System.out.printf("Cannot divide %.0f by zero", n1);
                }
                break;
        }
    }
}