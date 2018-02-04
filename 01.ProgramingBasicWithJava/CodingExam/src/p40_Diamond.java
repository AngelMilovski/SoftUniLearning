import java.util.Scanner;

public class p40_Diamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int widthDiamond = 5 * n;
        int dots = n;
        int stars = n * 3 - 2;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.printf("%s*%s*%s%n",
                        repeatStr(".", dots),
                        repeatStr("*", stars),
                        repeatStr(".", dots));
                dots--;
                stars += 2;
            } else {
                System.out.printf("%s*%s*%s%n",
                        repeatStr(".", dots),
                        repeatStr(".", stars),
                        repeatStr(".", dots));
                dots--;
                stars += 2;
            }
        }
        System.out.println(repeatStr("*", widthDiamond));
        int bottomDots = 1;
        int bottomMiddleDots = widthDiamond - 4;
        for (int j = 0; j < n * 2; j++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr(".", bottomDots),
                    repeatStr(".", bottomMiddleDots),
                    repeatStr(".", bottomDots));
            bottomDots++;
            bottomMiddleDots -= 2;
        }
        System.out.printf("%s*%s*%s%n",
                repeatStr(".", bottomDots),
                repeatStr("*", bottomMiddleDots),
                repeatStr(".", bottomDots));
    }

    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
