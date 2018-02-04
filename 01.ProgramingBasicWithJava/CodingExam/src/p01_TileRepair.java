import java.util.Scanner;

public class p01_TileRepair {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lengthOfTheSite = Integer.parseInt(scan.nextLine());
        double tileWidth = Double.parseDouble(scan.nextLine());
        double tileLength = Double.parseDouble(scan.nextLine());
        int benchWidth = Integer.parseInt(scan.nextLine());
        int benchLength = Integer.parseInt(scan.nextLine());

        int areaOfTheSite =  lengthOfTheSite * lengthOfTheSite;
        int areaBench = benchWidth * benchLength;
        double coverageArea = areaOfTheSite - areaBench;
        double areaTile = tileWidth * tileLength;
        double necessaryTiles = coverageArea / areaTile;

        System.out.printf("%.2f%n", necessaryTiles);
        System.out.printf("%.2f%n", necessaryTiles * 0.2);
    }
}
