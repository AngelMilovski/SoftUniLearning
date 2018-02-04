import java.util.Scanner;

public class p60_Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberOfChrysanthemumsPurchased = Double.parseDouble(scan.nextLine());
        double numberOfRosePurchased = Double.parseDouble(scan.nextLine());
        double numberOfTulipsPurchased = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String holidayOrNo = scan.nextLine();
        double priceChrysanthemums = 0.0;
        double priceRose = 0.0;
        double priceTulips = 0.0;

        if (season.equals("Spring") || season.equals("Summer")){
            priceChrysanthemums = 2.00;
            priceRose = 4.10;
            priceTulips = 2.50;
        }else if (season.equals("Autumn") || season.equals("Winter")){
            priceChrysanthemums = 3.75;
            priceRose = 4.50;
            priceTulips = 4.15;
        }

        double priceAllFlowers = (numberOfChrysanthemumsPurchased * priceChrysanthemums) + (numberOfRosePurchased * priceRose)+
                (numberOfTulipsPurchased * priceTulips);
        if (holidayOrNo.equals("Y")){
            priceAllFlowers = priceAllFlowers + (priceAllFlowers * 0.15);
        }

        if (season.equals("Spring")){
            if (numberOfTulipsPurchased > 7){
                priceAllFlowers = priceAllFlowers - (priceAllFlowers * 0.05);
            }
        }if (season.equals("Winter")){
            if (numberOfRosePurchased >= 10){
                priceAllFlowers = priceAllFlowers-(priceAllFlowers * 0.10);
            }
        }if ((numberOfChrysanthemumsPurchased + numberOfRosePurchased + numberOfTulipsPurchased) > 20){
            priceAllFlowers = priceAllFlowers - (priceAllFlowers * 0.20);
        }
        System.out.printf("%.2f", priceAllFlowers + 2);
    }
}
