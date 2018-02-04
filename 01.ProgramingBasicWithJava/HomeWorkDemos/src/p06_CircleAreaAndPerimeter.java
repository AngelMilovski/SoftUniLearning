import java.util.Scanner;

public class p06_CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double r = Double.parseDouble(scan.nextLine());
        double area = Math.PI * r * r;
        System.out.printf("%.2f\n", area);
        double perimeter = 2 * Math.PI * r;
        System.out.printf("%.2f", perimeter);
    }
}
