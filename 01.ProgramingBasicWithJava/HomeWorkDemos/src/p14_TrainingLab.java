import java.util.Scanner;

public class p14_TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double h = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());

        int a1 = (int) ((w * 100) - 100) / 70;
        int b1 = (int) ((h * 100) / 120);

        int total = (a1 * b1) - 3;
        System.out.println(total);
    }
}
