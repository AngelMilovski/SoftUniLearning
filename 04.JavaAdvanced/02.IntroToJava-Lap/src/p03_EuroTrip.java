import java.math.BigDecimal;
import java.util.Scanner;

public class p03_EuroTrip {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         double quantityWurst = Double.parseDouble(scan.next());
         double priceInBg = quantityWurst * 1.20;
         BigDecimal DM = new BigDecimal("4210500000000");
         DM = DM.multiply(new BigDecimal(priceInBg));

        System.out.println(String.format("%.2f marks", DM));
    }
}