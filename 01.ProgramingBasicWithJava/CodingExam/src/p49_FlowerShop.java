import java.util.Scanner;

public class p49_FlowerShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberMagnolias = Double.parseDouble(scan.nextLine());
        double numberHyacinths = Double.parseDouble(scan.nextLine());
        double numberRoses = Double.parseDouble(scan.nextLine());
        double numberCacti = Double.parseDouble(scan.nextLine());
        double priceGift = Double.parseDouble(scan.nextLine());

        double profitMagnolias = numberMagnolias * 3.25;
        double profitHyacinths = numberHyacinths * 4;
        double profitRoses = numberRoses * 3.50;
        double profitCacti = numberCacti * 8;
        double allProfit = profitMagnolias + profitHyacinths + profitRoses + profitCacti;
        double scot = allProfit * 0.05;
        double totalProfit = allProfit - scot;

        if (totalProfit < priceGift){
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(priceGift - totalProfit));
        }else if (totalProfit >= priceGift){
            System.out.printf("She is left with %.0f leva.", Math.floor(totalProfit - priceGift));
        }
    }
}
