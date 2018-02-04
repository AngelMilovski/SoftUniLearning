import java.util.Scanner;

public class p04_DogHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sideLengthA = Double.parseDouble(scan.nextLine());
        double sideHeightB = Double.parseDouble(scan.nextLine());

        double theTwoSides = sideLengthA * (sideLengthA / 2) * 2;
        double rearWall = ((sideLengthA / 2 * (sideHeightB - sideLengthA / 2)) / 2) + ((sideLengthA / 2) * (sideLengthA / 2));
        double enter = (sideLengthA / 5) * (sideLengthA / 5);
        double frontWall = rearWall - enter;
        double totalArea = theTwoSides + rearWall + frontWall;
        double greenPaint = totalArea / 3;
        double theRoof = sideLengthA * (sideLengthA / 2) * 2;
        double redPaint = theRoof / 5;

        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f%n", redPaint);
    }
}
