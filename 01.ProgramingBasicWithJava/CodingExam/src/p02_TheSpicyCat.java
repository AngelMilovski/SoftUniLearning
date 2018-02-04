import java.util.Scanner;

public class p02_TheSpicyCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int holidays = Integer.parseInt(scan.nextLine());

        int gamesInHolidays = holidays * 127;
        int gamesInWorkingDays = (365 - holidays) * 63;
        int totalGames = gamesInHolidays + gamesInWorkingDays;
        int diffInNorm = Math.abs(totalGames - 30000);
        int hours = diffInNorm / 60;
        int min = diffInNorm % 60;


        if (totalGames >= 30000){
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, min);
        }else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, min);
        }
    }
}
