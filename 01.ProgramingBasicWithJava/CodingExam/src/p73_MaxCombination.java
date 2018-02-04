import java.util.Scanner;

public class p53_MaxCombination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int maxCombinations = Integer.parseInt(scan.nextLine());
        int combination = 0;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                combination++;
                System.out.printf("<" + i + "-" + j + ">");
                if (combination == maxCombinations) {
                    return;
                }
            }

        }

    }
}
