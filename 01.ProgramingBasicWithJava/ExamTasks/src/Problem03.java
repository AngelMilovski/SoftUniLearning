import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String sizeCocktail = scan.nextLine();
        double numbersDrinks = Double.parseDouble(scan.nextLine());
        double priceDrink = 0.0;


        if (sizeCocktail.equals("small")) {
            if (fruit.equals("Watermelon")) {
                priceDrink = 2 * 56;
            } else if (fruit.equals("Mango")) {
                priceDrink = 2 * 36.66;
            } else if (fruit.equals("Pineapple")) {
                priceDrink = 2 * 42.10;
            } else if (fruit.equals("Raspberry")) {
                priceDrink = 2 * 20;
            }
        } else {
            if (fruit.equals("Watermelon")) {
                priceDrink = 5 * 28.70;
            } else if (fruit.equals("Mango")) {
                priceDrink = 5 * 19.60;
            } else if (fruit.equals("Pineapple")) {
                priceDrink = 5 * 24.80;
            } else if (fruit.equals("Raspberry")) {
                priceDrink = 5 * 15.20;
            }
        }
        double priceForCocktails = numbersDrinks * priceDrink;

        if (priceForCocktails > 1000) {
            priceForCocktails = priceForCocktails - (priceForCocktails * 0.50);
        } else if (priceForCocktails >= 400 && priceForCocktails <= 1000) {
            priceForCocktails = priceForCocktails - (priceForCocktails * 0.15);
        }
        System.out.printf("%.2f lv.", priceForCocktails);
    }
}
