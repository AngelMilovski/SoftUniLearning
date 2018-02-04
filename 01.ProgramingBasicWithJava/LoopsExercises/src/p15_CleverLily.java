import java.util.Scanner;

public class p15_CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());
        double washingMachinePrice = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        double giftMoney = 0.0;
        double savedMoney = 0.0;
        double numberOfToys = 0.0;
        double moneyFromToys = 0.0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                giftMoney += 10;
                savedMoney += giftMoney;
                savedMoney--;
            } else {
                numberOfToys++;
                moneyFromToys = numberOfToys * toyPrice;
            }
        }
        if ((savedMoney + moneyFromToys) >= washingMachinePrice) {

            System.out.printf("Yes! %.2f", (savedMoney + moneyFromToys) - washingMachinePrice);
        } else {
            System.out.printf("No! %.2f", Math.abs((savedMoney + moneyFromToys) - washingMachinePrice));
        }
    }
}
