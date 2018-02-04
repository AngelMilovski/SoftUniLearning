import java.util.Scanner;

public class p29_Exe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int dashes = 0;
        int rightDashes = n*2 -2;

        for (int i = 0; i < n ; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr("-", n * 3),
                    repeatStr("-", dashes),repeatStr("-", rightDashes));

            dashes++;
            rightDashes--;
        }
        for (int i = 0; i < n / 2 ; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr("*",n * 3),
                    repeatStr("-", dashes - 1 ),
                    repeatStr("-", rightDashes + 1 ));
        }
        int lowerLeftDashes = n * 3;
        for (int i = 0; i < n / 2 - 1; i++) {
            System.out.printf("%s*%s*%s%n",
                    repeatStr("-", lowerLeftDashes),
                    repeatStr("-", dashes - 1),
                    repeatStr("-", rightDashes + 1));

            lowerLeftDashes--;
            dashes += 2;
            rightDashes--;
        }
        System.out.printf("%s*%s*%s%n",
                repeatStr("-", lowerLeftDashes),
                repeatStr("*", dashes - 1),
                repeatStr("-",rightDashes + 1));



    }
    public static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
