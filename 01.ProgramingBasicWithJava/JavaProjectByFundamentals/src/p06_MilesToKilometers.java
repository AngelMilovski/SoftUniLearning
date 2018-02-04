import java.util.Scanner;

public class p06_MilesToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mile = Double.parseDouble(scan.nextLine());
        double kilometer = mile * 1.60934;

        System.out.printf("%.2f", kilometer);
    }
}
