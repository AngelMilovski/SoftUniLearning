import java.util.Scanner;

public class p47_TwoNumbersSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int magicalNumber = Integer.parseInt(scan.nextLine());
        int combination = 0;

        for (int i = n; i >= m; i--) {
            for (int j = n; j >= m; j--) {
                combination++;
                if (i + j == magicalNumber) {
                    System.out.print("Combination N:" + combination + " (" + i + " + " + j + " = " + magicalNumber + ")");
                    return;
                }
            }
        }
        System.out.print(combination + " combinations - neither equals " + magicalNumber);
    }
}
