import java.util.Scanner;

public class p21_Parallelepiped5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int width = 3 * n + 1;
        int height = 4 * n + 4;
        int topDots = n * 2;

        System.out.printf("+%s+%s%n", repeatStr("~", n - 2), repeatStr(".", width - (n - 2) - 2));

        for (int i = 0; i < (height - 2) / 2; i++) {
            System.out.printf("|%s\\%s\\%s%n",
                    repeatStr(".", i),
                    repeatStr("~", n - 2),
                    repeatStr(".", topDots));
            topDots--;
        }
        int bottomDots = width - (n - 2) - 3;
        for (int i = 0; i < (height - 2) / 2; i++) {
            System.out.printf("%s\\%s|%s|%n",
                    repeatStr(".", i),
                    repeatStr(".", bottomDots),
                    repeatStr("~", n - 2));
            bottomDots--;
        }
        System.out.printf("%s+%s+", repeatStr(".", width - (n - 2) - 2), repeatStr("~", n - 2));
    }
    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
