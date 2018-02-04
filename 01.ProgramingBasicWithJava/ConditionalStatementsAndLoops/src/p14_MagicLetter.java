import java.util.Scanner;

public class p14_MagicLetter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstLetter = scan.nextLine().charAt(0);
        char secondLetter = scan.nextLine().charAt(0);
        char thirdLetter = scan.nextLine().charAt(0);

        for (char i = firstLetter; i <= secondLetter; i++) {
            for (char j = firstLetter; j <= secondLetter; j++) {
                for (char k = firstLetter; k <= secondLetter; k++) {

                    if (i != thirdLetter && j != thirdLetter && k != thirdLetter) {
                        System.out.print("" + i + j + k +" ");
                    }
                }
            }
        }
    }
}
