import java.util.Scanner;

public class p09_TwoNumbersSum6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int magic = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                count++;
                if (i + j == magic) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", count, i, j, magic);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d%n", count, magic);
    }
}
