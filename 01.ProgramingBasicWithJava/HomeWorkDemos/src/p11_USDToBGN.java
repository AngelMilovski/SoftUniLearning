import java.util.Scanner;

public class p11_USDToBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double amount = Double.parseDouble(scan.nextLine());
        double usd = 1;
        double bgn = 1.79549;
        double converted = amount * bgn / usd;
        System.out.printf("%.2f", converted);
        System.out.printf(" BGN");


    }
}