import java.util.Scanner;

public class p15_DrawFort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan. nextLine());
        int columnWidth = n / 2;
        int towerWidth = n * 2;
        int middleDashes = (towerWidth) - (columnWidth * 2) - 4;

        System.out.printf("/%s\\%s/%s\\%n",
                repeatStr("^", columnWidth),
                repeatStr("_", middleDashes),
                repeatStr("^", columnWidth));

        for (int i = 0; i < n - 3; i++) {
            System.out.printf("|%s|%n", repeatStr(" ", towerWidth - 2));
        }
        System.out.printf("|%s%s%s|%n",
                repeatStr(" ", columnWidth + 1),
                repeatStr("_", middleDashes),
                repeatStr(" ", columnWidth + 1));

        System.out.printf("\\%s/%s\\%s/%n",
                repeatStr("_", columnWidth),
                repeatStr(" ", middleDashes),
                repeatStr("_", columnWidth));


    }
    public static String repeatStr (String str, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}
