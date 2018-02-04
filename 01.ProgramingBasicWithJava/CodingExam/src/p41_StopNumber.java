import java.util.Scanner;

public class p41_StopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int s = Integer.parseInt(scan.nextLine());

        for (int i = m; i >= n; i--) {
            if (i % 2 == 0 & i % 3 == 0) {
                int num = i;
                if (num == s) {
                    return;

                }
                System.out.printf(num + " ");
            }
        }

    }
}
