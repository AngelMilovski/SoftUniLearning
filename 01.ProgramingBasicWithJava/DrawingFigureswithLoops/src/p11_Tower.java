import java.util.Scanner;

public class p11_Tower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int columnWidth = n / 2;
        int towerWidth = n * 2;
        int lowerDashes = (towerWidth - 2) - n - 2;

        if (n % 2 == 0) {
            System.out.printf("/%s\\%s/%s\\%n",
                    repeatStr("^", columnWidth),
                    repeatStr("_", lowerDashes),
                    repeatStr("^", columnWidth));
            for (int i = 0; i < n - 3; i++) {
                System.out.printf("|%s|%n", repeatStr(" ", towerWidth - 2));
            }
            System.out.printf("|%s%s%s|%n",
                    repeatStr(" ", columnWidth + 1),
                    repeatStr("_", lowerDashes),
                    repeatStr(" ", columnWidth + 1));
            System.out.printf("\\%s/%s\\%s/%n",
                    repeatStr("_", columnWidth),
                    repeatStr(" ", lowerDashes),
                    repeatStr("_", columnWidth));
        } else {
            System.out.printf("/%s\\%s/%s\\%n",
                    repeatStr("^", columnWidth),
                    repeatStr("_", lowerDashes + 1),
                    repeatStr("^", columnWidth));
            for (int i = 0; i < n - 3; i++) {
                System.out.printf("|%s|%n", repeatStr(" ", towerWidth - 2));
            }
            System.out.printf("|%s%s%s|%n",
                    repeatStr(" ", columnWidth + 1),
                    repeatStr("_", lowerDashes + 1),
                    repeatStr(" ", columnWidth + 1));
            System.out.printf("\\%s/%s\\%s/%n",
                    repeatStr("_", columnWidth),
                    repeatStr(" ", lowerDashes + 1),
                    repeatStr("_", columnWidth));
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
