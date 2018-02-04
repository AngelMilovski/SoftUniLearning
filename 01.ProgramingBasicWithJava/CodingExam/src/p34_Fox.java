import java.util.Scanner;

public class p34_Fox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int widthFox = 2 * n + 3;
        int stars = 1;
        int dashes = n * 2 - 1;

        for (int i = 0; i < n; i++) {
            System.out.printf("%s\\%s/%s%n",
                    repeatStr("*",stars),
                    repeatStr("-", dashes),
                    repeatStr("*", stars));
            stars++;
            dashes -= 2;
        }
        int middleStars = n / 2;
        int middleStars2 = n;
        for (int i = 0; i < n / 3; i++) {
            System.out.printf("|%s\\%s/%s|%n",
                    repeatStr("*", middleStars),
                    repeatStr("*", middleStars2),
                    repeatStr("*", middleStars));

            middleStars++;
            middleStars2 -= 2;
        }
        int bottomDashes = 1;
        int bottomStars = n * 2 - 1;
        for (int i = 0; i < n; i++) {
            System.out.printf("%s\\%s/%s%n",
                    repeatStr("-", bottomDashes),
                    repeatStr("*", bottomStars),
                    repeatStr("-", bottomDashes));
            bottomDashes++;
            bottomStars -= 2;
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
