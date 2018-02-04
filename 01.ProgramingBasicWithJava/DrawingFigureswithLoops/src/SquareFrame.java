import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        System.out.printf("+ %s+", repeatStr("- ", number - 2));

        for (int row = 0; row < number - 2; row++) {
            System.out.printf("| %s|%n", repeatStr("-", number - 2));
        }
        System.out.printf("+ %s+", repeatStr("- ", number - 2));
    }


    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}