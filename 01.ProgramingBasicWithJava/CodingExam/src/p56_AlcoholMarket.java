import java.util.Scanner;

public class p56_AlcoholMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceWhiskyInLv = Double.parseDouble(scan.nextLine());
        double quantityOfBeersInL = Double.parseDouble(scan.nextLine());
        double quantityOfWineInL = Double.parseDouble(scan.nextLine());
        double quantityRakiaInL = Double.parseDouble(scan.nextLine());
        double quantityWhiskyInL = Double.parseDouble(scan.nextLine());

        double priceRakia = priceWhiskyInLv / 2;
        double priceWine = priceRakia - (priceRakia * 0.40);
        double priceBeer = priceRakia - (priceRakia * 0.80);
        double sumRakia = priceRakia * quantityRakiaInL;
        double sumWine = priceWine * quantityOfWineInL;
        double sumBeer = priceBeer * quantityOfBeersInL;
        double sumWhisky = priceWhiskyInLv * quantityWhiskyInL;
        double totalSum = sumRakia + sumWine + sumBeer + sumWhisky;
        System.out.printf("%.2f", totalSum);
    }
}
