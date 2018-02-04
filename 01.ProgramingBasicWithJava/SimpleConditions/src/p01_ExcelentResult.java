import java.util.Scanner;

public class p01_ExcelentResult {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        if (number >= 5.50) {
            System.out.println("Excellent!");
        }

    }
}
