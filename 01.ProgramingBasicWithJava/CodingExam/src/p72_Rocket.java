import java.util.Scanner;

public class p52_Rocket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int wightRocket = 3 * n;
        int dots = (wightRocket - 2) / 2;
        int emptyRol = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("%s/%s\\%s%n",
                    repeatStr(".", dots),
                    repeatStr(" ", emptyRol),
                    repeatStr(".", dots));
            dots--;
            emptyRol += 2;
        }
        System.out.printf("%s%s%s%n",
                repeatStr(".", n / 2),
                repeatStr("*", n * 2),
                repeatStr(".", n / 2));
        for (int i = 0; i < n * 2; i++) {
            System.out.printf("%s|%s|%s%n",
                    repeatStr(".", n / 2),
                    repeatStr("\\", n * 2 - 2),
                    repeatStr(".", n / 2));
        }
        int bottomDots = n / 2;
        int stars = n * 2 - 2;
        for (int i = 0; i < n / 2; i++) {
            System.out.printf("%s/%s\\%s%n",
                    repeatStr(".", bottomDots),
                    repeatStr("*", stars),
                    repeatStr(".", bottomDots));
            bottomDots--;
            stars += 2;
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
