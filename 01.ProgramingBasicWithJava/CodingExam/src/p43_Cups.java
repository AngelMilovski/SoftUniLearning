import java.util.Scanner;

public class p43_Cups {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberCupNeededWorkOut = Double.parseDouble(scan.nextLine());
        double numberWorkers = Double.parseDouble(scan.nextLine());
        double workingDays = Double.parseDouble(scan.nextLine());

        double madeCups = Math.floor((numberWorkers * workingDays * 8) / 5);
        double cupsLv = Math.abs(numberCupNeededWorkOut - madeCups) * 4.2;
        if (madeCups < numberCupNeededWorkOut) {
            System.out.printf("Losses: %.2f", cupsLv);
        } else {
            System.out.printf("%.2f extra money", cupsLv);
        }
    }
}
