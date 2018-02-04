import java.util.Scanner;

public class Crown {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int width = 2 * n - 1;
        System.out.println(
                "@" +
                        repeatString(" ", n - 2) +
                        "@" +
                        repeatString(" " , n - 2) +
                        "@"
        );

        int dots = 1;
        int spaces = n - 3;
        System.out.println(
                "**" +
                        repeatString(" ", spaces) +
                        "*" +
                        repeatString(" ", spaces) +
                        "**"
        );

        spaces -= 2;
        int middleDots = dots;
        for (int i = 0; i < n / 2 - 2; i++) {
            System.out.println(
                    "*" +
                            repeatString(".", dots) +
                            "*" +
                            repeatString(" ", spaces) +
                            "*" +
                            repeatString(".", middleDots) +
                            "*" +
                            repeatString(" ", spaces) +
                            "*" +
                            repeatString(".", dots) +
                            "*"
            );

            spaces -= 2;
            dots += 1;
            middleDots += 2;
        }

        System.out.println(
                "*" +
                        repeatString(".", dots) +
                        "*" +
                        repeatString(".", middleDots) +
                        "*" +
                        repeatString(".", dots) +
                        "*"
        );

        dots += 1;
        System.out.println(
                "*" +
                        repeatString(".", dots) +
                        repeatString("*", n / 2 - 2) +
                        "." +
                        repeatString("*", n / 2 - 2) +
                        repeatString(".", dots) +
                        "*"
        );

        for (int i = 0; i < 2; i++) {
            System.out.println(repeatString("*",  (2 * n) - 1));
        }
    }

    public static String repeatString(String string, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += string;
        }

        return result;
    }
}
