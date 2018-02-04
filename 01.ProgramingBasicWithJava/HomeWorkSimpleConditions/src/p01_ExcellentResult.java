import java.util.Scanner;

public class p01_ExcellentResult {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());

        if (num >= 5.50){
            System.out.println("Excellent!");
        }
    }
}
