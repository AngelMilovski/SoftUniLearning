import java.util.Scanner;

public class p03_SmartLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());
        double priceWashingMachine = Double.parseDouble(scan.nextLine());
        int toysPrice = Integer.parseInt(scan.nextLine());

        double toys = 0.0;
        double moneyFromToys = 0.0;
        double moneyGift = 0.0;
        double savedMoney = 0.0;


        for (int i = 1; i <= age ; i += 2) {
            toys++;
            moneyFromToys = toys * toysPrice;

        }
        for (int i = 2; i <= age ; i += 2) {
            moneyGift += 10;
            savedMoney += moneyGift;
            savedMoney--;

        }
        if ((savedMoney + moneyFromToys) >= priceWashingMachine){
            System.out.printf("Yes! %.2f",(savedMoney + moneyFromToys) - priceWashingMachine);
        }else {
            System.out.printf("No! %.2f", Math.abs((savedMoney + moneyFromToys) - priceWashingMachine));
        }

    }
}
