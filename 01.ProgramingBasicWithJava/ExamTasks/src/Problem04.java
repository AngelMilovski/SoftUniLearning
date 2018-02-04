import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int project = Integer.parseInt(scan.nextLine());
        double moneyAward = Double.parseDouble(scan.nextLine());
        double numberPoints = 0.0;

        for (int i = 1; i <= project; i++) {
            double point = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                numberPoints += point * 2;
            } else {
                numberPoints += point;
            }
        }
        System.out.printf("The project prize was %.2f lv.", numberPoints * moneyAward);
    }
}
