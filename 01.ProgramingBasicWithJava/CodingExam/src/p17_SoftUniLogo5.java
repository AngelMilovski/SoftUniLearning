import java.util.Scanner;

public class p17_SoftUniLogo5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int widthColumns = 12 * n - 5;
//        int heightColumns = 4 * n - 2;
        int dots = widthColumns / 2;
        int hashtag = 1;
        int dots2 = 3;
        int hashtag2 = widthColumns - 2 * dots2;

        for (int i = 0; i < n * 2; i++) {
            System.out.println(repeatStr(".", dots) + repeatStr("#", hashtag) + repeatStr(".", dots));

            dots -= 3;
            hashtag += 6;
        }
        for (int i = 0; i < n - 2; i++) {
            System.out.println("|" + repeatStr(".", dots2 - 1) + repeatStr("#", hashtag2) +
                    repeatStr(".", dots2));
            dots2 += 3;
            hashtag2 -= 6;
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println("|" + repeatStr(".", dots2 - 1) + repeatStr("#", hashtag2) + repeatStr(".",dots2));
        }
        System.out.println("@" + repeatStr(".", dots2 - 1) + repeatStr("#", hashtag2) + repeatStr(".", dots2));
    }

    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
