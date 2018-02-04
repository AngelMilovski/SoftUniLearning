import java.util.Scanner;

public class p66_DanceHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double lengthHallInM = Double.parseDouble(scan.nextLine());
        double widthHallInM = Double.parseDouble(scan.nextLine());
        double sideWardrobeInM = Double.parseDouble(scan.nextLine());

        double sideHallInSquareSm = (lengthHallInM * 100) * (widthHallInM * 100);
        double sideWardrobeInSquareSm = (sideWardrobeInM * 100) * (sideWardrobeInM * 100);
        double sideBench = sideHallInSquareSm / 10;

        double freeSpace = sideHallInSquareSm - sideWardrobeInSquareSm - sideBench;
        double numberDancer = freeSpace / (40 + 7000);

        System.out.printf("%.0f", Math.floor(numberDancer));
    }
}
