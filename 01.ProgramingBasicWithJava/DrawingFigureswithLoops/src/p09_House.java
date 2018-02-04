import java.util.Scanner;

public class p09_House {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int height = (n + 1) / 2;
        int startAsterisk = 0;
        if (n % 2 == 0){
            startAsterisk = 2;
        }else {
            startAsterisk = 1;
        }
        int dashes = (n - startAsterisk) / 2;

        for (int row = 0; row < height; row++) {
            System.out.printf("%s%s%s%n",
                    repeatStr("-", dashes - row),
                    repeatStr("*", startAsterisk + 2 * row),
                    repeatStr("-", dashes - row));
        }

        for (int i = 0; i < n /2; i++) {
            System.out.printf("|%s|%n", repeatStr("*", n - 2));
        }
    }
    public static String repeatStr (String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
