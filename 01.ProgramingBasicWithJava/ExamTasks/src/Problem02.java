import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double recordInSec = Double.parseDouble(scan.nextLine());
        double distanceInMeters = Double.parseDouble(scan.nextLine());
        double timeInSecForOneMeter = Double.parseDouble(scan.nextLine());

        double swimInSec = distanceInMeters * timeInSecForOneMeter;
        double fifteenMetersPlusSec = Math.floor(distanceInMeters / 15) * 12.5;
        double totalTime = swimInSec + fifteenMetersPlusSec;

        if (totalTime >= recordInSec) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", totalTime - recordInSec);
        } else if (totalTime < recordInSec) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }
    }
}
