import java.util.Scanner;

public class StupidPasswordGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (char k = 'a'; k < 'a' + l; k++) {
                    for (char m = 'a'; m < 'a' + l; m++) {
                        for (int o = Math.max(i, j) + 1; o <= n; o++) {
                            System.out.print("" + i + j + k + m + o + " ");
                        }
                    }
                }
            }
        }
    }
}
