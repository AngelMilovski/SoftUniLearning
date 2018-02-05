import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class p07_ProductOfNumbersInRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      //  BigInteger product = new BigInteger("1");
        BigDecimal product = new BigDecimal("1");
        int n = scan.nextInt();
        int m = scan.nextInt();
        int index = n;
        do {
            product = product.multiply(new BigDecimal(index));
      //      product = product.multiply(new BigInteger(String.valueOf(index)));
            index++;
        } while (index <= m);

        System.out.println(String.format("product[%d..%d] = %.0f", n, m, product));
    }
}