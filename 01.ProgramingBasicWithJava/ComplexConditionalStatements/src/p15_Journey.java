import java.util.Scanner;

public class p15_Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double costs = -1;

        if (budget <= 100) {
            if (season.equals("summer")){
            costs = (budget / 100) * 30;
                System.out.println("Somewhere in Bulgaria");
                System.out.printf("Camp - %.2f", costs);
            }else if (season.equals("winter")){
                costs = (budget / 100) * 70;
                System.out.println("Somewhere in Bulgaria");
                System.out.printf("Hotel - %.2f", costs);
            }

        } else if (budget > 100 && budget <= 1000) {
            if (season.equals("summer")){
                costs = (budget / 100) * 40;
                System.out.println("Somewhere in Balkans");
                System.out.printf("Camp - %.2f", costs);
            }else if (season.equals("winter")){
                costs = (budget / 100) * 80;
                System.out.println("Somewhere in Balkans");
                System.out.printf("Hotel - %.2f", costs);
            }
        } else if (budget > 1000) {
            costs = (budget / 100) * 90;
            System.out.println("Somewhere in Europe");
            System.out.printf("Hotel - %.2f", costs);
        }
    }
}