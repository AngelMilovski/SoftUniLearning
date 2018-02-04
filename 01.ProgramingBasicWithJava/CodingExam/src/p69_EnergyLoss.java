import java.util.Scanner;

public class p69_EnergyLoss {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberOfTrainingDays = Double.parseDouble(scan.nextLine());
        double numberDancer = Double.parseDouble(scan.nextLine());
        double oddTrainingAndOddHours = 0.0;
        double oddTrainingAndEvenHours = 0.0;
        double evenTrainingAndEvenHours = 0.0;
        double evenTrainingAndOddHours = 0.0;

        for (int i = 1; i <= numberOfTrainingDays; i++) {
            int hoursOfTraining = Integer.parseInt(scan.nextLine());
            if (i % 2 == 1){
                if (hoursOfTraining % 2 == 1){
                    oddTrainingAndOddHours += 30 * numberDancer;
                }else {
                    oddTrainingAndEvenHours += 49 * numberDancer;
                }
            }else {
                if (hoursOfTraining % 2 == 0){
                    evenTrainingAndEvenHours += 68 * numberDancer;
                }else {
                    evenTrainingAndOddHours += 65 * numberDancer;
                }
            }
        }
        double totalEnergyForAllDancersDays = 100 * numberOfTrainingDays * numberDancer;
        double energyForAllDays = totalEnergyForAllDancersDays - (oddTrainingAndEvenHours + oddTrainingAndOddHours +
                evenTrainingAndEvenHours + evenTrainingAndOddHours);
        double energyOfDancerForADay = energyForAllDays / numberDancer / numberOfTrainingDays;

        if (energyOfDancerForADay <= 50){
            System.out.printf("They are wasted! Energy left: %.2f", energyOfDancerForADay);
        }else {
            System.out.printf("They feel good! Energy left: %.2f", energyOfDancerForADay);
        }
    }
}
