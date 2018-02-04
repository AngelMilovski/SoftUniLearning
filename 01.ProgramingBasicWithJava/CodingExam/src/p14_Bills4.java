
import java.util.Scanner;

public class p14_Bills4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int months = Integer.parseInt(scan.nextLine());

        double water = months * 20.0;
        double internet = months * 15.0;
        double electricity = 0.0;
        double otherExpenses = 0.0;
//        double other = 0.0;

        for (int i = 0; i < months; i++) {
            double electricityAccount = Double.parseDouble(scan.nextLine());
            electricity += electricityAccount;
            otherExpenses += (electricityAccount + 20 + 15) + ((electricityAccount + 20 + 15) * 0.2);
 //           other += otherExpenses;
        }
        double average = (electricity + water + internet + otherExpenses) / months;

        System.out.printf("Electricity: %.2f lv%nWater: %.2f lv%nInternet: %.2f lv%nOther: %.2f lv%nAverage: %.2f lv%n",
                electricity, water, internet, otherExpenses, average);
    }
}
