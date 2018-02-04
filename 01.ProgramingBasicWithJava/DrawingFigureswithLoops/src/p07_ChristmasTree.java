import java.util.Scanner;

public class p07_ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n + 1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n - row - 1; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <= row; i++) {
                System.out.print("*");
            }
            System.out.print(" | ");
            for (int i = 0; i <= row; i++) {
                System.out.print("*");
            }


            System.out.println();
        }

    }

    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}