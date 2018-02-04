import java.util.Scanner;

public class p25_Fishland1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceMackerelForKg = Double.parseDouble(scan.nextLine());
        double priceSpratForKg = Double.parseDouble(scan.nextLine());
        double pricePalmwoodForKg = Double.parseDouble(scan.nextLine());
        double priceSaffriteForKg = Double.parseDouble(scan.nextLine());
        int kgShellfish = Integer.parseInt(scan.nextLine());

        double pricePalmwood = priceMackerelForKg + priceMackerelForKg * 0.60;
        double sumPalmwood = pricePalmwood * pricePalmwoodForKg;
        double priceSaffrite = priceSpratForKg + priceSpratForKg * 0.80;
        double sumSaffrite = priceSaffriteForKg * priceSaffrite;
        double sumShellfish = kgShellfish * 7.5;
        double totalPrice = sumPalmwood + sumSaffrite + sumShellfish;
        System.out.printf("%.2f", totalPrice);
    }
}
