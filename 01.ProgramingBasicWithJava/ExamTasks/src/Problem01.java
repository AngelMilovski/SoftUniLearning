import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberDaysInCampaign = Double.parseDouble(scan.nextLine());
        double numberConfectioners = Double.parseDouble(scan.nextLine());
        double numberCakes = Double.parseDouble(scan.nextLine());
        double numberWaffles = Double.parseDouble(scan.nextLine());
        double numberPancakes = Double.parseDouble(scan.nextLine());

        double numberOfCakesFromOneConfectioner = numberCakes * 45;
        double numberWafflesFromOneConfectioner = numberWaffles * 5.80;
        double numberPancakesFromOneConfectioner = numberPancakes * 3.20;
        double allSum = (numberOfCakesFromOneConfectioner + numberWafflesFromOneConfectioner + numberPancakesFromOneConfectioner) * numberConfectioners;
        double allSumFromCompany = allSum * numberDaysInCampaign;
        double sumAfterCosts = allSumFromCompany - (allSumFromCompany / 8);
        System.out.printf("%.2f", sumAfterCosts);
    }
}
