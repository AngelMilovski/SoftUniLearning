import java.util.Scanner;

public class p15_VegetableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceVegetables = Double.parseDouble(scan.nextLine());
        double priceFruits = Double.parseDouble(scan.nextLine());

        int kgVegetables = Integer.parseInt(scan.nextLine());

        int kgFruits = Integer.parseInt(scan.nextLine());

        double incomeVegetables = priceVegetables * kgVegetables;

        double incomeFruits = priceFruits * kgFruits;

        double priceEuro = (incomeVegetables + incomeFruits) / 1.94;

        System.out.printf("%.2f", priceEuro);


    }
}
