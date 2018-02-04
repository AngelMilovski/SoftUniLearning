import java.util.Scanner;

public class p10_Diamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int startAsteriskCount = 0;
        int topPartHeight = 0;
        if (n % 2 == 0){
            startAsteriskCount = 2;
            topPartHeight = n / 2;
        }else {
            startAsteriskCount = 1;
            topPartHeight = n / 2 + 1;
        }
        int dashesCount = (n - startAsteriskCount) / 2;

        for (int i = 0; i < topPartHeight; i++) {
            if (i == 0) {
                System.out.printf("%s%s%s%n",
                        repeatStr("-", dashesCount),
                        repeatStr("*", startAsteriskCount),
                        repeatStr("-", dashesCount));
            }else {
                System.out.printf("%s*%s*%s%n",
                        repeatStr("-", dashesCount - i),
                        repeatStr("-", startAsteriskCount + 2 * i - 2),
                        repeatStr("-", dashesCount - i));
            }

        }
        for (int i = 1; i < topPartHeight; i++) {
            if (i == topPartHeight - 1){
                System.out.printf("%s%s%s%n",
                        repeatStr("-", dashesCount),
                        repeatStr("*", startAsteriskCount),
                        repeatStr("-", dashesCount));

            }else {
                System.out.printf("%s*%s*%s%n",
                        repeatStr("-", i),
                        repeatStr("-", n - 2 - 2 * i),
                        repeatStr("-", i));
            }
        }
    }
    public static String repeatStr (String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
