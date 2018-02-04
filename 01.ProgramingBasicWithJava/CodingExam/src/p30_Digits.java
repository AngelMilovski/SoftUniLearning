import java.util.Scanner;

public class p30_Digits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int sum = num;
        int l = num % 10;
        int m = num % 100 / 10;
        int n = num / 100;

        for (int i = 1; i <= n + m; i++) {
            for (int j = 1; j <= n + l; j++) {

                if (sum % 5 == 0) {
                    sum = sum - n;
                } else if (sum % 3 == 0) {
                    sum = sum - m;
                } else {
                    sum = sum + l;
                }
                System.out.print("" + sum + " ");

            }
            System.out.println();
        }
    }
}

