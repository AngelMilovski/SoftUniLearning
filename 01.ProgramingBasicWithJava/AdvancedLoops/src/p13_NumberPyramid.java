import java.util.Scanner;

public class p13_NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(count + " ");
                count++;
                if (count > n){
                    return;
                }
            }
            System.out.println();

        }
    }

}
