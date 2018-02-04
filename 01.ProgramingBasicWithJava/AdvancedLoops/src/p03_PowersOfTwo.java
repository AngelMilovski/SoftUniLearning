import java.util.Scanner;

public class p03_PowersOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int number = 1;

        for (int i = 1; i <= n + 1; i++) {
            System.out.println(number);
            number *= 2;

        }
    }
}
