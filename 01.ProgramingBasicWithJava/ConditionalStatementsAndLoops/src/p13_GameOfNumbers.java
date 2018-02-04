import java.util.Scanner;

public class p13_GameOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int combinations = 0;

        for (int i = m; i >= n; i--) {
            for (int j = m; j >= n; j--) {
                sum = i + j;
                combinations++;
                if (i > j && sum == magicNumber){
                    System.out.println(String.format("Number found! %s + %s = %d", i, j, sum));
                    return;
                }
            }
        }
        System.out.println(String.format("%s combinations - neither equals %d", combinations, magicNumber));

    }
}
