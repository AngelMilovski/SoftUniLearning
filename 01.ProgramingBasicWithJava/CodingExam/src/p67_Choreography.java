import java.util.Scanner;

public class p67_Choreography {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberSteps = Double.parseDouble(scan.nextLine());
        double dancer = Double.parseDouble(scan.nextLine());
        double numberDaysForLearning = Double.parseDouble(scan.nextLine());

        double numbersOfStepsADay = Math.ceil(((numberSteps / numberDaysForLearning) / numberSteps * 100));
        double percentOfStepsForAllDancer = numbersOfStepsADay / dancer;

        if (numbersOfStepsADay <= 13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.", percentOfStepsForAllDancer);
        }else {
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.", percentOfStepsForAllDancer);
        }
    }
}
