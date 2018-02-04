import java.util.Scanner;

public class p55_ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double costOfExcursion = Double.parseDouble(scan.nextLine());
        double numberPuzzle = Double.parseDouble(scan.nextLine());
        double talkingDolls = Double.parseDouble(scan.nextLine());
        double teddyBears = Double.parseDouble(scan.nextLine());
        double numberMinions = Double.parseDouble(scan.nextLine());
        double trucks = Double.parseDouble(scan.nextLine());

        double sumPuzzle = numberPuzzle * 2.60;
        double sumDolls = talkingDolls * 3;
        double sumTeddyBears = teddyBears * 4.10;
        double sumMinions = numberMinions * 8.20;
        double sumTrucks= trucks * 2;
        double allSum = sumPuzzle + sumDolls + sumTeddyBears + sumMinions + sumTrucks;
        double numberToys = numberMinions + numberPuzzle + talkingDolls + teddyBears + trucks;
        if (numberToys >= 50){
            allSum = allSum - (allSum * 0.25);
        }
        double allSumWithoutTenPercent = allSum - allSum * 0.10;
        if (allSumWithoutTenPercent >= costOfExcursion){
            System.out.printf("Yes! %.2f lv left.", allSumWithoutTenPercent - costOfExcursion);
        }
        else {
            System.out.printf("Not enough money! %.2f lv needed.", costOfExcursion - allSumWithoutTenPercent);
        }
    }
}
