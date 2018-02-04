import java.util.Scanner;

public class p46_Hourglass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int dots = 1;
        int monkeyA = n * 2 - 3;
        int wightAndHeightHourglass = 2 * n + 1;

        System.out.printf("%s%n", repeatStr("*", wightAndHeightHourglass));
        System.out.printf("%s*%s*%s%n",
                repeatStr(".", dots),
                repeatStr(" ", monkeyA),
                repeatStr(".", dots));
        dots ++;
        monkeyA -= 2;
        for (int i = 0; i < n - 2; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr(".", dots),
                    repeatStr("@", monkeyA),
                    repeatStr(".", dots));
            dots++;
            monkeyA -= 2;
        }
        System.out.printf("%s*%s%n",
                repeatStr(".", (wightAndHeightHourglass - 1) / 2),
                repeatStr(".", (wightAndHeightHourglass - 1) / 2));

        int bottomPoint = n - 1;
        int emptyCol = 0;
        for (int i = 0; i < n -2; i++) {
            System.out.printf("%s*%s@%s*%s%n",
                    repeatStr(".", bottomPoint),
                    repeatStr(" ", emptyCol),
                    repeatStr(" ", emptyCol),
                    repeatStr(".", bottomPoint));
            bottomPoint--;
            emptyCol++;
        }
        System.out.printf("%s*%s@%s*%s%n",
                repeatStr(".", bottomPoint),
                repeatStr("@", emptyCol),
                repeatStr("@", emptyCol),
                repeatStr(".", bottomPoint));
        System.out.printf("%s", repeatStr("*", wightAndHeightHourglass));








    }
    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
