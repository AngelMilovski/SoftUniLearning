import java.util.Scanner;

public class p39_BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inheritedMoney = Double.parseDouble(scan.nextLine());
        int theYearHeHasToLiveWith = Integer.parseInt(scan.nextLine());
        int n = theYearHeHasToLiveWith - 1800;
        int age = 17;
        double residue = inheritedMoney;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                age++;
                residue -= 12000;
            } else {
                age++;
                residue = residue - (12000 + age * 50);
            }
        }
        if (residue >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", residue);
        } else if (residue < 0) {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(residue));
        }
    }
}
