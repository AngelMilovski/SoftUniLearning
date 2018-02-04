import java.util.Scanner;

public class p62_LettersCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);
        char third = scan.nextLine().charAt(0);
        int count = 0;


        for (char i = first; i <= second; i++) {
            for (char j = first; j <= second; j++) {
                for (char k = first; k <= second; k++) {
                    if (i != third && j != third && k != third) {
                        System.out.print("" + i + j + k + " ");
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
