import java.util.Scanner;

public class p13_SoftUniCamp4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfGroups = Integer.parseInt(scan.nextLine());
        double allPeople = 0.0;
        double peopleWithCar = 0.0;
        double peopleWithMinibus = 0.0;
        double peopleWithSmallBus = 0.0;
        double peopleWithBigBus = 0.0;
        double peopleWithTrain = 0.0;

        for (int i = 0; i < numberOfGroups; i++) {
            int numberOfPeople = Integer.parseInt(scan.nextLine());
            allPeople += numberOfPeople;
            if (numberOfPeople <= 5) {
                peopleWithCar += numberOfPeople;
            } else if (numberOfPeople > 5 && numberOfPeople <= 12) {
                peopleWithMinibus += numberOfPeople;
            } else if (numberOfPeople > 12 && numberOfPeople <= 25) {
                peopleWithSmallBus += numberOfPeople;
            } else if (numberOfPeople > 25 && numberOfPeople <= 40) {
                peopleWithBigBus += numberOfPeople;
            } else if (numberOfPeople > 40) {
                peopleWithTrain += numberOfPeople;
            }
        }
        double percentPeopleWithCar = peopleWithCar / allPeople * 100;
        double percentPeopleWithMinibus = peopleWithMinibus / allPeople * 100;
        double percentPeopleWithSmallBus = peopleWithSmallBus / allPeople * 100;
        double percentPeopleWithBigBus = peopleWithBigBus / allPeople * 100;
        double percentPeopleWithTrain = peopleWithTrain / allPeople * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", percentPeopleWithCar, percentPeopleWithMinibus,
                percentPeopleWithSmallBus, percentPeopleWithBigBus, percentPeopleWithTrain);
    }
}
