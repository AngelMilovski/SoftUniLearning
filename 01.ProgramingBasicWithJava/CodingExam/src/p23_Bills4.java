import java.util.Scanner;

public class p23_Bills4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mounts = Integer.parseInt(scan.nextLine());
        double water = mounts * 20;
        double internet = mounts * 15;
        double electricity = 0.0;
        double other = 0.0;
        for (int i = 0; i < mounts; i++) {
            double electricityCount = Double.parseDouble(scan.nextLine());
            electricity += electricityCount;
            other += (electricityCount + 20 + 15) + ((electricityCount + 20 + 15) * 0.2);
        }
        double average = (electricity + water + internet + other) / mounts;
        System.out.printf("Electricity: %.2f lv%n", electricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", other);
        System.out.printf("Average: %.2f lv%n",average);
    }
}
