import java.util.Scanner;

public class p06_BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter score: ");
        int number = Integer.parseInt(scan.nextLine());
        double bonusScore = 0.0;

        if (number > 1000) {
            bonusScore += number * 0.10;
        } else if (number > 100 && number < 1000) {
            bonusScore += number * 0.20;
        } else if (number <= 100) {
            bonusScore += 5;
        }
        if (number % 2 == 0) {
            bonusScore += 1;
        } else if (number % 10 == 5) {
            bonusScore += 2;
        }
        System.out.println("Bonus score: " + bonusScore);
        System.out.println("Total score: " + (number + bonusScore));

    }
}
