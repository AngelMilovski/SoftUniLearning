import java.util.Scanner;


public class p12_Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String year = scan.nextLine();
        double holidayInYear = Double.parseDouble(scan.nextLine());
        double weekendInHomeTown = Double.parseDouble(scan.nextLine());

        double weekendInYear = 48 - weekendInHomeTown;
        double holidayInSofia = weekendInYear * 3 / 4;
        double weekendInHisTown = weekendInHomeTown;
        double playsInSofiaWeekend = holidayInYear * 2 / 3;


        double totalGame = (holidayInSofia + weekendInHisTown + playsInSofiaWeekend);


        if (year.equals("normal")) {
            double result = Math.floor(totalGame);
            System.out.printf("%.0f", result);

        } else if (year.equals("leap")) {
            double result = 0.15 * totalGame;
            double percentMorePlays = result + totalGame;
            double plusPercent = Math.floor(percentMorePlays);
            System.out.printf("%.0f", plusPercent);

        }
    }
}


