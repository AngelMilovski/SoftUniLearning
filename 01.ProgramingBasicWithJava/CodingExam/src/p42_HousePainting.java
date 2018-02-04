import java.util.Scanner;

public class p42_HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double heightHouse = Double.parseDouble(scan.nextLine());
        double sidewallLength = Double.parseDouble(scan.nextLine());
        double heightTriangleSideRoof = Double.parseDouble(scan.nextLine());

        double sideWall = heightHouse * sidewallLength;
        double window = 1.5 * 1.5;
        double allSides = (2 * sideWall) - (2 * window);
        double rearWall = heightHouse * heightHouse;
        double doorway = 2 * 1.2;
        double frontAndRearWall = 2 * rearWall - doorway;
        double totalArea = allSides + frontAndRearWall;
        double neededGreenPaint = totalArea / 3.4;

        double twoRectangleOnRoof = 2 * (heightHouse * sidewallLength);
        double twoTriangle = 2 * (heightHouse * heightTriangleSideRoof / 2);
        double allArea = twoRectangleOnRoof + twoTriangle;
        double neededRedPaint = allArea / 4.3;
        System.out.printf("%.2f%n", neededGreenPaint);
        System.out.printf("%.2f%n", neededRedPaint);
    }
}
