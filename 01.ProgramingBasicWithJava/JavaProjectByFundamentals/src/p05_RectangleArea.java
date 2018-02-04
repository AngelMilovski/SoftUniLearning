import java.text.DecimalFormat;
import java.util.Scanner;

public class p05_RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");

        double height = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double area = height * width;

        System.out.println(df.format(area));
    }
}
