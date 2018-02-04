import java.util.Scanner;

public class p63_Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double costs = 0.0;
        String where = "";
        String campOrHotel = "";

        if (budget <= 100) {
            where = "Somewhere in Bulgaria";
            if (season.equals("summer")) {
                campOrHotel = "Camp";
                costs = budget * 0.30;
            } else {
                campOrHotel = "Hotel";
                costs = budget * 0.70;
            }
        } else if (budget > 100 && budget <= 1000) {
            where = "Somewhere in Balkans";
            if (season.equals("summer")) {
                campOrHotel = "Camp";
                costs = budget * 0.40;
            } else {
                campOrHotel = "Hotel";
                costs = budget * 0.80;
            }
        } else {
            where = "Somewhere in Europe";
            campOrHotel = "Hotel";
            costs = budget * 0.90;
        }
        System.out.println(where);
        System.out.printf("%s - %.2f", campOrHotel, costs);
    }
}
