import java.util.Scanner;

public class p06_BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter score: ");

        int num = Integer.parseInt(scan.nextLine());
        double bonusScore = 0.0;

        if (num > 1000) {
            bonusScore = num * 0.10;
        } else if (num > 100) {
            bonusScore = num * 0.20;

        } else if (num <= 100) {
            bonusScore += 5;
        }
        if (num % 10 == 5) {
            bonusScore += 2;

        } else if (num % 2 == 0) {
            bonusScore += 1;
        }
        System.out.println("Bonus score: " + bonusScore);
        System.out.println("Total score: " + (num + bonusScore));


    }
}
