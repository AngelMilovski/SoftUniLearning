import java.util.Scanner;

public class p06_NumberInRangeFrom1To100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());

        while (input < 1 || input > 100){
            System.out.println("Invalid number!");

            input = Integer.parseInt(scan.nextLine());
        }
        System.out.println("The number is: " + input);
    }
}
