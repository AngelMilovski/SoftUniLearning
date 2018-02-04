import java.util.Scanner;

public class p12_Butterfly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int wingWidth = (n - 2);
        int butterflyWing = (n - 2);

        for (int i = 0; i < butterflyWing; i++) {
            if (i % 2 == 0) {
                System.out.printf("%s\\ /%s%n",
                        repeatStr("*", wingWidth),
                        repeatStr("*", wingWidth));
            } else {
                System.out.printf("%s\\ /%s%n",
                        repeatStr("-", wingWidth),
                        repeatStr("-", wingWidth));
            }
        }
        System.out.printf("%s@%s%n",
                repeatStr(" ", n - 1),
                repeatStr(" ", n - 1));
        for (int i = 0; i < butterflyWing; i++) {
            if (i % 2 == 0) {
                System.out.printf("%s/ \\%s%n",
                        repeatStr("*", wingWidth),
                        repeatStr("*", wingWidth));
            } else {
                System.out.printf("%s/ \\%s%n",
                        repeatStr("-", wingWidth),
                        repeatStr("-", wingWidth));
            }
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
