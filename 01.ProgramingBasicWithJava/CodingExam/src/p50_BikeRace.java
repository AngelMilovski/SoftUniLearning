import java.util.Scanner;

public class p50_BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberJuniorBikers = Double.parseDouble(scan.nextLine());
        double numberSeniorBikers = Double.parseDouble(scan.nextLine());
        String typeRoute = scan.nextLine();
        double juniors = 0.0;
        double seniors = 0.0;

        if (typeRoute.equals("cross-country")) {
            if (numberJuniorBikers + numberSeniorBikers >= 50) {
                juniors = 8 - (8 * 0.25);
                seniors = 9.50 - (9.50 * 0.25);
            } else {
                juniors = 8;
                seniors = 9.50;
            }
        } else if (typeRoute.equals("trail")) {
            juniors = 5.50;
            seniors = 7;
        } else if (typeRoute.equals("downhill")) {
            juniors = 12.25;
            seniors = 13.75;
        } else if (typeRoute.equals("road")) {
            juniors = 20;
            seniors = 21.50;
        }
        double totalSum = (juniors * numberJuniorBikers + seniors * numberSeniorBikers) -
                (juniors * numberJuniorBikers + seniors * numberSeniorBikers) * 0.05;
        System.out.printf("%.2f", totalSum);

    }
}
