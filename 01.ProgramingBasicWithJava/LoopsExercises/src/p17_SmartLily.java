import java.util.Scanner;

public class p17_SmartLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());
        double washingMachinePrice = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());
        int oddAge;
        int evenAge;

        if (age % 2 == 1) {
            oddAge = age / 2 + 1;
            evenAge = age / 2;
        } else {
            oddAge = age / 2;
            evenAge = age / 2;
        }
        double totalPriceToys = oddAge * toyPrice;
        double moneySaved = (evenAge * (evenAge + 1) / 2 * 10);
        double brotherTakenMoney = evenAge * 1.0;
        double totalMoneySaved = moneySaved + totalPriceToys - brotherTakenMoney;
        double leftOver = Math.abs(totalMoneySaved- washingMachinePrice);

        if (totalMoneySaved >= washingMachinePrice){

            System.out.printf("Yes! %.2f", leftOver);
        }else {

            System.out.printf("No! %.2f", leftOver);
        }
    }
}
