import java.util.Scanner;

import static sun.misc.Version.print;

public class p05_TransportPrice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double km;
        km = Double.parseDouble(scan.nextLine());
        String dayTime;
        dayTime = scan.nextLine();
        double price = 0.0;
        if (km >= 100) {
            price = priceWithTrain(km);
        } else if (km >= 20 && km < 100) {
            price = priceWithBus(km);
        } else {
            price = priceWithTaxi(dayTime, km);
        }
        printPriceOfTheTrip(price);
    }

    public static double priceWithTrain(double km) {

        return 0.06 * km;
    }

    public static double priceWithBus(double km) {
        return 0.09 * km;
    }

    public static double priceWithTaxi(String dayTime, double km) {
        return partOfTheDay(dayTime) * km + 0.70;
    }

    public static double partOfTheDay(String dayTime) {
        switch (dayTime) {
            case "day":
                return 0.79;
            default:
                return 0.90;
        }
    }

    private static void printPriceOfTheTrip(double price) {
        System.out.println(String.format("%.2f", price));
    }
}