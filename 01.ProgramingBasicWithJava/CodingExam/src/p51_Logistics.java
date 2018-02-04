import java.util.Scanner;

public class p51_Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberLoads = Integer.parseInt(scan.nextLine());
        double sum = 0.0;
        double minibus = 0.0;
        double truck = 0.0;
        double train = 0.0;

        for (int i = 0; i < numberLoads; i++) {
            int freightTonnage = Integer.parseInt(scan.nextLine());
            sum += freightTonnage;
            if (freightTonnage <= 3){
                minibus += freightTonnage;
            }else if (freightTonnage > 3 && freightTonnage <= 11){
                truck += freightTonnage;
            }else {
                train += freightTonnage;
            }
        }

        double pricePerTon = (minibus * 200 + truck * 175 + train * 120) / sum;
        double percentMinibus = minibus / sum * 100;
        double percentTruck = truck / sum * 100;
        double percentTrain = train / sum * 100;

        System.out.printf("%.2f%n",pricePerTon);
        System.out.printf("%.2f%%%n", percentMinibus);
        System.out.printf("%.2f%%%n", percentTruck);
        System.out.printf("%.2f%%%n", percentTrain);
    }
}
