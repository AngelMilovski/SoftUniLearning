import java.util.Scanner;

public class p02_TriangleArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double aX = scan.nextInt();
        double aY = scan.nextInt();
        double bX = scan.nextInt();
        double bY = scan.nextInt();
        double cX = scan.nextInt();
        double cY = scan.nextInt();

        double sideA = side(bY, cY);
        double sideB = side(cY, aY);
        double sideC = side(aY, bY);

        double area = Math.abs(((aX * sideA) + (bX * sideB) + (cX * sideC)) / 2);
        int result = (int)(area);

        System.out.println(result);
    }

    private static double side(double a, double b) {
        return a - b;
    }
}