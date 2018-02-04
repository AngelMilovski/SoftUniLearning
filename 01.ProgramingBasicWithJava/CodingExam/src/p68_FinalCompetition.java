import java.util.Scanner;

public class p68_FinalCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberDancer = Double.parseDouble(scan.nextLine());
        double numberPoints = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String place = scan.next();

        double prizeMoney= 0.0;
        double prizeMoneyWithCosts = 0.0;



        if (place.equals("Bulgaria")) {
            prizeMoney = numberDancer * numberPoints;
        } else {
            prizeMoney = numberDancer * numberPoints + (numberDancer * numberPoints * 0.5);
        }
        if (place.equals("Bulgaria")){
            if (season.equals("summer")){
                prizeMoneyWithCosts = prizeMoney - (prizeMoney * 0.05);
            }else {
                prizeMoneyWithCosts = prizeMoney - (prizeMoney * 0.08);
            }
        }else {
            if (season.equals("summer")){
                prizeMoneyWithCosts = prizeMoney - (prizeMoney * 0.10);
            }else {
                prizeMoneyWithCosts = prizeMoney - (prizeMoney * 0.15);
            }
        }
        double moneyForCharity = (prizeMoneyWithCosts * 0.75);
        double remainingMoney = prizeMoneyWithCosts - moneyForCharity;

        System.out.printf("Charity - %.2f%n", moneyForCharity);
        System.out.printf("Money per dancer - %.2f", remainingMoney / numberDancer);

    }
}
