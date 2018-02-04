import java.util.Scanner;

public class p54_ProgrammerDNA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char l = scan.nextLine().charAt(0);
        char letters = l;
        int dots = 3;
        int counter = 0;

        while (counter < n) {
            for (int i = 1; i <= 8; i++) {
                System.out.printf("%s", repeatStr(".", dots));
                for (int j = 0; j < i; j++) {
                    System.out.print(letters);
                    if (letters == 'A' + 6) {
                        letters = 'A';

                    } else {
                        letters++;
                    }
                }
                System.out.printf("%s%n", repeatStr(".", dots));
                dots--;
                i++;
                counter++;
                if (counter == n) {
                    return;
                }
                if (dots == -1) {
                    dots = 3;
                }
            }
            int bottomDots = 1;
            for (int i = 6; i >= 1; i--) {
                System.out.printf("%s", repeatStr(".", bottomDots));
                for (int j = i - 1; j > 0; j--) {
                    System.out.print(letters);
                    if (letters == 'A' + 6) {
                        letters = 'A';
                    } else {
                        letters++;
                    }
                }
                System.out.printf("%s%n", repeatStr(".", bottomDots));
                bottomDots++;
                i--;
                counter++;
                if (counter == n) {
                    return;
                }
                if (bottomDots == 4) {
                    bottomDots = 1;
                }
            }
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
