import java.util.Scanner;

public class p13_SignStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int topPartHeight = (n * 2) - 2;
        int points = n;
        int lowerDashes = (n * 2) - 1;
        int lowerDashesBottomPart = (n * 4) - 3;

        System.out.printf("%s%s%s%n",
                repeatStr(".", points + 1),
                repeatStr("_", lowerDashes + 2),
                repeatStr(".", points + 1));

        for (int i = 0; i < n; i++) {
            System.out.printf("%s//%s\\\\%s%n",
                    repeatStr(".", points - i),
                    repeatStr("_", lowerDashes + 2 * i),
                    repeatStr(".", points - i));
            if (i == n - 1) {
                System.out.printf("//%sSTOP!%s\\\\%n",
                        repeatStr("_", ((lowerDashes + 2 * i + 2) - 5) / 2),
                        repeatStr("_", ((lowerDashes + 2 * i + 2) - 5) / 2));
            }
        }
        System.out.printf("\\\\%s//%n", repeatStr("_", (n * 4) - 1));
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("%s\\\\%s//%s%n",
                    repeatStr(".", (points / n) + i),
                    repeatStr("_", lowerDashesBottomPart - 2 * i),
                    repeatStr(".", (points / n) + i));
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
