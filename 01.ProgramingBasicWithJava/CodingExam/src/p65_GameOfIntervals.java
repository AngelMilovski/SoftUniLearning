import java.util.Scanner;

public class p65_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int movesTheGame = Integer.parseInt(scan.nextLine());
        double result = 0.0;
        double fromZeroToNIne = 0.0;
        double fromTenToNineteen = 0.0;
        double fromTwentyToTwentyNine = 0.0;
        double fromThirtyToThirtyNine = 0.0;
        double fromFortyToFifty = 0.0;
        double invalidNumbers = 0.0;

        for (int i = 0; i < movesTheGame; i++) {
            int move = Integer.parseInt(scan.nextLine());
            if (move >= 0 && move <= 9) {
                fromZeroToNIne++;
                result += move * 0.20;
            } else if (move > 9 && move <= 19) {
                fromTenToNineteen++;
                result += move * 0.30;
            } else if (move > 19 && move <= 29) {
                fromTwentyToTwentyNine++;
                result += move * 0.40;
            } else if (move > 29 && move <= 39) {
                fromThirtyToThirtyNine++;
                result += 50;
            } else if (move > 39 && move <= 50) {
                fromFortyToFifty++;
                result += 100;
            } else if (move < 0 || move > 50) {
                invalidNumbers++;
                result /= 2;
            }
        }
        double percentFromZeroToNIne = fromZeroToNIne / movesTheGame * 100;
        double percentFromTenToNineteen = fromTenToNineteen / movesTheGame * 100;
        double percentFromTwentyToTwentyNine = fromTwentyToTwentyNine / movesTheGame * 100;
        double percentFromThirtyToThirtyNine = fromThirtyToThirtyNine / movesTheGame * 100;
        double percentFromFortyToFifty = fromFortyToFifty / movesTheGame * 100;
        double percentInvalidNumber = invalidNumbers / movesTheGame * 100;

        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", percentFromZeroToNIne);
        System.out.printf("From 10 to 19: %.2f%%%n", percentFromTenToNineteen);
        System.out.printf("From 20 to 29: %.2f%%%n", percentFromTwentyToTwentyNine);
        System.out.printf("From 30 to 39: %.2f%%%n", percentFromThirtyToThirtyNine);
        System.out.printf("From 40 to 50: %.2f%%%n", percentFromFortyToFifty);
        System.out.printf("Invalid numbers: %.2f%%%n", percentInvalidNumber);
    }
}
