import java.util.Scanner;

public class p48_HousePrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double areaTheSmallestRoom = Double.parseDouble(scan.nextLine());
        double areaKitchen = Double.parseDouble(scan.nextLine());
        double priceOfSquareMeter = Double.parseDouble(scan.nextLine());

        double secondRoom = areaTheSmallestRoom + (areaTheSmallestRoom * 0.1);
        double thirdRoom = secondRoom + (secondRoom * 0.1);
        double bathroom = areaTheSmallestRoom / 2;
        double totalArea = (areaTheSmallestRoom + areaKitchen + secondRoom + thirdRoom + bathroom);
        double corridor = totalArea * 0.05;
        double totalAreaWithCorridor = totalArea + corridor;
        System.out.printf("%.2f", totalAreaWithCorridor * priceOfSquareMeter);
    }
}
