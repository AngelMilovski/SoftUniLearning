import java.util.Scanner;

public class p12_Logistics4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberIfLoads = Integer.parseInt(scan.nextLine());
        double allLoads = 0.0;
        double minibus = 0.0;
        double priceMinibus = 0.0;
        double truck = 0.0;
        double priceTruck = 0.0;
        double train = 0.0;
        double priceTrain = 0.0;

        for (int i = 0; i < numberIfLoads; i++) {
            int ton = Integer.parseInt(scan.nextLine());
            allLoads += ton;
            if (ton <= 3) {
                minibus += ton;
                priceMinibus = minibus * 200;
            } else if (ton > 3 && ton <= 11) {
                truck += ton;
                priceTruck = truck * 175;
            } else if (ton > 11) {
                train += ton;
                priceTrain = train * 120;
            }
        }
        double averagePrice = (priceMinibus + priceTruck + priceTrain) / allLoads;
        double percentMinibus = minibus / allLoads * 100;
        double percentTruck = truck / allLoads * 100;
        double percentTrain = train / allLoads * 100;
        System.out.printf("%.2f%n%.2f%%%n%.2f%%%n%.2f%%%n", averagePrice, percentMinibus, percentTruck, percentTrain);
    }
}
