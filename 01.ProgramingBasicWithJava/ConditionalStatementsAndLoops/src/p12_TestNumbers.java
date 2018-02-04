import java.util.Scanner;

public class p12_TestNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int maximumSum = Integer.parseInt(scan.nextLine());
        int sumFromCombination = 0;
        int combinations = 0;

        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= m; j++) {
                sumFromCombination += 3 * (i * j);
                combinations++;
                if (sumFromCombination >= maximumSum){
                    System.out.println(combinations + " combinations");
                    System.out.println(String.format("Sum: %d >= %d", sumFromCombination, maximumSum));
                    return;
                }
            }
        }
        System.out.println(combinations + " combinations");
        System.out.println(String.format("Sum: %d", sumFromCombination));
    }
}
