import java.util.Scanner;

public class p22_Crown {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int height = n / 2 + 4;
        int emptyRow = n - 3;
        int dots = 1;
        int middleDots = 1;
        int width = 2 * n - 1;

        System.out.printf("@%s@%s@%n", repeatStr(" ", n - 2), repeatStr(" ", n - 2));
        System.out.printf("**%s*%s**%n", repeatStr(" ", emptyRow), repeatStr(" ", emptyRow));
        emptyRow -= 2;

        for (int i = 0; i < height - 6; i++) {
            System.out.printf("*%s*%s*%s*%s*%s*%n",
                    repeatStr(".", dots),
                    repeatStr(" ", emptyRow),
                    repeatStr(".", middleDots),
                    repeatStr(" ", emptyRow),
                    repeatStr(".", dots));
            dots++;
            emptyRow -= 2;
            middleDots += 2;
        }
        System.out.printf("*%s*%s*%s*%n",
                repeatStr(".", dots),
                repeatStr(".", middleDots),
                repeatStr(".", dots));
        dots++;
        System.out.printf("*%s%s.%s%s*%n",
                repeatStr(".", dots),
                repeatStr("*", (n - 4) / 2),
                repeatStr("*", (n - 4) / 2),
                repeatStr(".", dots));

        for (int i = 0; i < 2; i++) {
            System.out.println(repeatStr("*", width));
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
