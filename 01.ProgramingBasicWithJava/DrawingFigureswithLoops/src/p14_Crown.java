import java.util.Scanner;

public class p14_Crown {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int width = (2 * n) - 1;
        int height = (n / 2) + 4;
        int emptyRow = n - 3;
        System.out.printf("@%s@%S@%n",
                repeatStr(" ", n - 2),
                repeatStr(" ", n - 2));
        System.out.printf("**%s*%s**%n",
                repeatStr(" ", emptyRow),
                repeatStr(" ", emptyRow));

        for (int i = 1, j=n-5; i < (n / 2) - 1; i++,j=j-2) {
            System.out.printf("*%s*%s*%s*%s*%s*%n",
                    repeatStr(".", i ),
                    repeatStr(" ", j),
                    repeatStr(".", width-6-2*i-2*j ),
                    repeatStr(" ", j),
                    repeatStr(".", i));
        }
        System.out.printf("*%s*%s*%s*%n",
                repeatStr(".", n / 2 - 1),
                repeatStr(".", (n/2 -1) + (n /2 - 1) -1),
                repeatStr(".", n /2 - 1));

        System.out.printf("*%s%s.%s%s*%n",
                repeatStr(".", n / 2),
                repeatStr("*", n / 2 - 2),
                repeatStr("*", n / 2 - 2),
                repeatStr(".", n / 2));

        for (int i = 0; i < 2; i++) {
            System.out.printf("%s%n", repeatStr("*", width));

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