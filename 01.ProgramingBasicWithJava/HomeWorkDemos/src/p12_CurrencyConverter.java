import java.util.Scanner;

public class p12_CurrencyConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double amount = Double.parseDouble(scan.nextLine());
        String currency1 = scan.nextLine();
        String currency2 = scan.nextLine();
        String BGN = "BGN";
        String USD = "USD";
        String EUR = "EUR";
        String GBP = "GBP";

        double bgn = 1;
        double usd = 1.79549;
        double eur = 1.95583;
        double gbp = 2.53405;

        if (currency1.equals(BGN) && currency2.equals(USD)) {
            double converted = amount * bgn / usd;
            System.out.printf("%.2f", converted);
            System.out.print(" USD");

        } else if (currency1.equals(USD) && currency2.equals(BGN)) {
            double converted = amount * usd / bgn;
            System.out.printf("%.2f", converted);
            System.out.print(" BGN");

        } else if (currency1.equals(BGN) && currency2.equals(EUR)) {
            double converted = amount * bgn / eur;
            System.out.printf("%.2f", converted);
            System.out.printf(" EUR");

        } else if (currency1.equals(EUR) && currency2.equals(BGN)) {
            double converted = amount * bgn / eur;
            System.out.printf("%.2f", converted);
            System.out.print(" BGN");

        } else if (currency1.equals(BGN) && currency2.equals(GBP)) {
            double converted = amount * bgn / gbp;
            System.out.printf("%.2f", converted);
            System.out.printf(" GBP");

        } else if (currency1.equals(GBP) && currency2.equals(BGN)) {
            double converted = amount * gbp / bgn;
            System.out.printf("%.2f", converted);
            System.out.printf(" BGN");
        } else if (currency1.equals(USD) && currency2.equals(EUR)) {
            double converted = amount * usd / eur;
            System.out.printf("%.2f", converted);
            System.out.print(" EUR");
        } else if (currency1.equals(EUR) && currency2.equals(USD)) {
            double converted = amount * eur / usd;
            System.out.printf("%.2f", converted);
            System.out.printf(" USD");
        } else if (currency1.equals(USD) && currency2.equals(GBP)) {
            double converted = amount * usd / gbp;
            System.out.printf("%.2f", converted);
            System.out.printf(" GBP");
        } else if (currency1.equals(GBP) && currency2.equals(USD)) {
            double converted = amount * gbp / usd;
            System.out.printf("%.2f", converted);
            System.out.print(" USD");
        } else if (currency1.equals(EUR) && currency2.equals(GBP)) {
            double converted = amount * eur / gbp;
            System.out.printf("%.2f", converted);
            System.out.printf(" GBP");
        } else if (currency1.equals(GBP) && currency2.equals(EUR)) {
            double converted = amount * gbp / eur;
            System.out.printf("%.2f", converted);
            System.out.printf(" EUR");
        } else {
            System.out.println("Please enter correct data");
        }
    }
}
