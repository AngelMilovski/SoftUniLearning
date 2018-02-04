import java.util.Scanner;

public class p19_Styrofoam2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double houseArea = Double.parseDouble(scan.nextLine());
        int windows = Integer.parseInt(scan.nextLine());
        double packageStyrofoam = Double.parseDouble(scan.nextLine());
        double pricePerPackageStyrofoam = Double.parseDouble(scan.nextLine());

        double totalHouseArea = houseArea - (windows * 2.4);
        double percent = totalHouseArea * 0.10;
        double houseAreaPlusTenPercent = totalHouseArea + percent;
        double packageNeeded = Math.ceil(houseAreaPlusTenPercent / packageStyrofoam);
        double totalPriceStyrofoam = packageNeeded * pricePerPackageStyrofoam;
        if (totalPriceStyrofoam <= budget){
            System.out.printf("Spent: %.2f%n", totalPriceStyrofoam);
            System.out.printf("Left: %.2f%n", Math.abs(budget - totalPriceStyrofoam));
        }
        else {
            System.out.printf("Need more: %.2f", Math.abs(totalPriceStyrofoam - budget));
        }
    }
}
