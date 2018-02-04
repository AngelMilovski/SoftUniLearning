import java.util.Scanner;

public class p70_Cup {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int widthCup = 5 * n;
        int diez = widthCup - (2 * n + 2);
        int points = n;

        for (int i = 0; i < n / 2; i++) {
            System.out.printf("%s#%s#%s%n", repeatStr(".", points), repeatStr("#", diez), repeatStr(".", points));
            points++;
            diez -= 2;
        }
        for (int i = 0; i <n / 2 + 1; i++) {
            System.out.printf("%s#%s#%s%n",repeatStr(".", points), repeatStr(".", diez), repeatStr(".", points));
            points++;
            diez -= 2;
        }
        System.out.printf("%s#%s#%s%n", repeatStr(".", points - 1), repeatStr("#", diez +2),repeatStr(".", points -1));
            points -= 3;
            int bottomPoints = (n * 2 - 2);
        for (int i = 0; i < n / 2; i++) {
            System.out.printf("%s%s%s%n", repeatStr(".", n * 2 - 2), repeatStr("#",widthCup -(2 * bottomPoints) ), repeatStr(".", n*2-2));
        }
        System.out.printf("%sD^A^N^C^E^%S%n",repeatStr(".",(widthCup - 10) / 2),repeatStr(".",(widthCup - 10) / 2));
        for (int i = 0; i < n / 2 + 1; i++) {
            System.out.printf("%s%s%s%n", repeatStr(".",n*2-2),repeatStr("#",widthCup-(2*bottomPoints)), repeatStr(".", n*2-2));
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
