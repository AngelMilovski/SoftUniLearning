import java.util.Scanner;

public class p08_Sunglasses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int glassWidth = n * 2;
        System.out.printf("%s%s%s%n",
                repeatStr("*", glassWidth),
                repeatStr(" ", n),
                repeatStr("*", glassWidth));

        for (int i = 0; i < n - 2; i++) {
            if (i == (n - 1) / 2 - 1){
                System.out.printf("*%s*%s*%s*%n",
                        repeatStr("/", glassWidth - 2),
                        repeatStr("|", n),
                        repeatStr("/", glassWidth - 2));
            }else {
                System.out.printf("*%s*%s*%s*%n",
                        repeatStr("/", glassWidth - 2),
                        repeatStr(" ", n),
                        repeatStr("/", glassWidth - 2));
            }

        }
        System.out.printf("%s%s%s%n",
                repeatStr("*", glassWidth),
                repeatStr(" ", n),
                repeatStr("*", glassWidth));
    }
    public static String repeatStr (String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
