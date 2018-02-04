import java.util.Scanner;

public class p33_SoftUniCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberGroupStudents = Integer.parseInt(scan.nextLine());
        int allGroup = 0;
        double groupCar = 0.0;
        double groupMinibus = 0.0;
        double groupSmallBus = 0.0;
        double groupBigBus = 0.0;
        double groupTrain = 0.0;

        for (int i = 0; i < numberGroupStudents; i++) {
            int oneGroup = Integer.parseInt(scan.nextLine());
            allGroup += oneGroup;
            if (oneGroup <= 5) {
                groupCar += oneGroup;
            } else if (oneGroup > 5 && oneGroup <= 12) {
                groupMinibus += oneGroup;
            } else if (oneGroup > 12 && oneGroup <= 25) {
                groupSmallBus += oneGroup;
            } else if (oneGroup > 25 && oneGroup <= 40) {
                groupBigBus += oneGroup;
            } else {
                groupTrain += oneGroup;
            }
        }
        double percentGroupCar = groupCar / allGroup * 100;
        double percentGroupMInibus = groupMinibus / allGroup * 100;
        double percentGroupSmallBus = groupSmallBus / allGroup * 100;
        double percentGroupBigBus = groupBigBus / allGroup * 100;
        double percentGroupTrain = groupTrain / allGroup * 100;

        System.out.printf("%.2f%%%n", percentGroupCar);
        System.out.printf("%.2f%%%n", percentGroupMInibus);
        System.out.printf("%.2f%%%n", percentGroupSmallBus);
        System.out.printf("%.2f%%%n", percentGroupBigBus);
        System.out.printf("%.2f%%%n",percentGroupTrain);
    }
}

