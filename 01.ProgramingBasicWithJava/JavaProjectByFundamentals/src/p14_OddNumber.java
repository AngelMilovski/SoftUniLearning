import java.util.Scanner;

public class p14_OddNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(scan.next());
            if (number % 2 == 0){
                System.out.println("Please write an odd number.");
                continue;
            }else {
                System.out.println("The number is: " + Math.abs(number));
                break;
            }

        }
    }
}
