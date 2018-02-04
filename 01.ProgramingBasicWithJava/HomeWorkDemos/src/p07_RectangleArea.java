import java.util.Scanner;

public class p07_RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());

        double x = Math.abs(x2 - x1);
        double y = Math.abs(y1 - y2);

        double area = x * y;


        double perimeter = 2 * (x + y);
        System.out.println(area);
        System.out.println(perimeter);

    }
}
