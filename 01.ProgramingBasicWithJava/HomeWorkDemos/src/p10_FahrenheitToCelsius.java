import java.util.Scanner;

public class p10_FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double F = Double.parseDouble(scan.nextLine());
         double C = (F - 32) / 1.8;

        System.out.printf("%.2f", C);
    }
}
