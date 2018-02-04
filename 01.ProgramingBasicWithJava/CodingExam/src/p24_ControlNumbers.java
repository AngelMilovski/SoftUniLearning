import java.util.Scanner;

public class p24_ControlNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int control = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= 1; j--) {
                sum += (i * 2) + (j * 3);
                count++;
                if (sum >= control){
                    System.out.println(count + " moves");
                    System.out.println("Score: " + sum + " >= " + control);
                    return;
                }
            }
        }
        System.out.println(count + " moves");
    }
}
