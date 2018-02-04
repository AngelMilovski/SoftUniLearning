import java.util.Scanner;

public class p08_Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int result = 1;

        for (int i = 1; i <= n ; i++) {
            result *= i;
        }
//        while (n != 0){
//            result *= n;
//            n--;
//        }
//        System.out.println(result);
    }
}
