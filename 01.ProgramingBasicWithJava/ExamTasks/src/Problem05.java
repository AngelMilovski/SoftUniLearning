import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int widthRectangle = 4 * n + 1;
        int heightRectangle = 2 * n + 1;
        int dots = 1;
        int emptyRol = 1;
        int diez = n * 2 - 1;
        int m = heightRectangle - ((n / 2) + (n));

        System.out.printf("%s%n", repeatStr("#", widthRectangle));
        for (int i = 0; i < n / 2; i++) {
            System.out.printf("%s%s%s%s%s%n",
                    repeatStr(".", dots),
                    repeatStr("#", diez),
                    repeatStr(" ", emptyRol),
                    repeatStr("#", diez),
                    repeatStr(".", dots));
            dots++;
            diez -= 2;
            emptyRol += 2;

        }
        System.out.printf("%s%s%s(@)%s%s%s%n",
                repeatStr(".", dots),
                repeatStr("#", diez),
                repeatStr(" ", (emptyRol - 3) / 2),
                repeatStr(" ", (emptyRol - 3) / 2),
                repeatStr("#", diez),
                repeatStr(".", dots));
        dots++;
        diez -= 2;
        for (int i = 0; i < m - 2; i++) {
            System.out.printf("%s%s%s%s%s%n",
                    repeatStr(".", dots),
                    repeatStr("#", diez),
                    repeatStr(" ", emptyRol + 2),
                    repeatStr("#", diez),
                    repeatStr(".", dots));
            dots++;
            diez -= 2;
            emptyRol += 2;
        }
        int bottomDiez = n * 2 - 1;
        for (int i = 0; i < n; i++) {
            System.out.printf("%s%s%s%n",
                    repeatStr(".", dots),
                    repeatStr("#", bottomDiez),
                    repeatStr(".", dots));
            dots++;
            bottomDiez -= 2;

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
