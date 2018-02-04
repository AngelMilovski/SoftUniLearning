import java.util.Scanner;

public class p09_CountTheIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counterNumber = 0;
        try {
            while (true) {
                int number = Integer.parseInt(scan.nextLine());
                counterNumber++;
            }
        } catch (NumberFormatException ex) {
            System.out.println(counterNumber);
        }
    }
}
