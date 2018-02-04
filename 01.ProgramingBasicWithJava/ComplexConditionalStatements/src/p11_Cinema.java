import java.util.Scanner;

public class p11_Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String projection = scan.nextLine();
        double r = Double.parseDouble(scan.nextLine());
        double c = Double.parseDouble(scan.nextLine());

        double result = -1;

        if (projection.equals("Premiere")) {
            result = 12.00 * r * c;
            System.out.printf("%.2f", result);
            System.out.println(" leva");

        } else if (projection.equals("Normal")) {
            result = 7.50 * r * c;
            System.out.printf("%.2f", result);
            System.out.println(" leva");

        } else if (projection.equals("Discount")) {
            result = 5.00 * r * c;
            System.out.printf("%.2f", result);
            System.out.println(" leva");

        }
    }

}
