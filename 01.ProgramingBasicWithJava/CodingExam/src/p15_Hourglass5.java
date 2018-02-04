import java.util.Scanner;

public class p15_Hourglass5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int lengthAndWidthHourglass = 2 * n + 1;
        int dots = 2;
        int monkeyA = lengthAndWidthHourglass - (2 * dots) - 2;
        int emptyCol = 0;



        System.out.println(repeatStr("*", lengthAndWidthHourglass));
        System.out.println(".*" + repeatStr(" ", lengthAndWidthHourglass - 4) + "*.");

        for (int row = 0; row < n - 2; row++) {
            System.out.println(
                    repeatStr(".", dots)
                            + "*" +
                            repeatStr("@", monkeyA)
                            + "*" +
                            repeatStr(".", dots));
            dots++;
            monkeyA -= 2;
        }
        System.out.println(repeatStr(".", dots) + "*" + repeatStr(".", dots));
        dots++;
        int bottomDots = n - 1;
        for (int i = 0; i < n - 2; i++) {
            System.out.println(
                    repeatStr(".", bottomDots)
                            + "*" +
                    repeatStr(" ", emptyCol)
                            + "@" +
                    repeatStr(" ", emptyCol)
                            + "*" +
                    repeatStr(".", bottomDots));
            bottomDots--;
            emptyCol++;
        }
        System.out.println(".*" + repeatStr("@", lengthAndWidthHourglass - 4) + "*.");
        System.out.println(repeatStr("*", lengthAndWidthHourglass));

    }

    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}


