import java.util.Scanner;

public class p37_Harvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double squareMetersIsVineyard = Double.parseDouble(scan.nextLine());
        double grapeForSquareMeter = Double.parseDouble(scan.nextLine());
        double neededLittersWine = Double.parseDouble(scan.nextLine());
        double numberWorkers = Double.parseDouble(scan.nextLine());

        double allGrape = squareMetersIsVineyard * grapeForSquareMeter;

        double wine = (0.4 * allGrape / 2.5);

        if (wine >= neededLittersWine) {
            double leftLiters =wine - neededLittersWine;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.",Math.ceil(leftLiters),Math.ceil(leftLiters / numberWorkers));
        } else {
            double neededLiters = (neededLittersWine - wine);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",Math.floor(neededLiters));
        }
    }
}
