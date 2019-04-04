import java.util.Scanner;

public class p06_HitTheTarget {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == n){
                    System.out.println(i + " + " + j + " = " + n);
                }else if (i - j == n){
                    System.out.println(i + " - " + j + " = " + n);
                }
            }
        }
    }
}