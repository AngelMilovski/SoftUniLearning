import java.util.Scanner;

public class p05_IntervalOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        if (a > b){
            for (int i = b; i <= a; i++) {
                System.out.println(i);
            }
        }else {
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        }
    }
}
