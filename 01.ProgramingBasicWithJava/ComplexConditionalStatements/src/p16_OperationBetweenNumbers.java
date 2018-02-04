import java.util.Scanner;

public class p16_OperationBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        String sign = scan.nextLine();
        double result = -1;

        if (sign.equals("+")){
            result = num1 + num2;
            if (result % 2 == 0){
                System.out.printf("%.0f + %.0f = %.0f - even", num1, num2, result);
            }else {
                System.out.printf("%.0f + %.0f = %.0f - odd", num1, num2, result);
            }
        }else if (sign.equals("-")){
            result = num1 - num2;
            if (result % 2 == 0){
                System.out.printf("%.0f - %.0f = %.0f - even", num1, num2, result);
            }else {
                System.out.printf("%.0f - %.0f = %.0f - odd", num1, num2, result);
            }
        }else if (sign.equals("*")){
            result = num1 * num2;
            if (result % 2 ==0){
                System.out.printf("%.0f * %.0f = %.0f - even", num1, num2, result);
            }else {
                System.out.printf("%.0f * %.0f = %.0f - odd", num1, num2, result);
            }
        }else if (sign.equals("/")){
            result = num1 / num2;
            if (num2 != 0){
                System.out.printf("%.0f / %.0f = %.2f", num1, num2, result);
            }else {
                System.out.printf("Cannot divide %.0f by zero", num1);
            }
        }else if (sign.equals("%")){
            result = num1 % num2;
            if (num2 != 0){
                System.out.printf("%.0f %% %.0f = %.0f", num1, num2, result);
            }else {
                System.out.printf("Cannot divide %.0f by zero", num1);
            }
        }
    }
}
