import java.util.Scanner;

public class p14_NumberTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                int num = row + col + 1;
//
//                if (num > n) {
//                    num = n * 2 - num;
//                }
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }

        for (int row = 0; row < n; row++) {
            int count = row + 1;
            for (int col = 0; col < n; col++) {
                count = row + col + 1;
                if (count > n) {
                    count = 2 * n - count;
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}