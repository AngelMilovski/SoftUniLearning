import java.util.Scanner;

public class p09_SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        do{
            int divN = n % 10;
            sum += divN;
            n /= 10;
        }while (n != 0);

        System.out.println(sum);
    }
}
