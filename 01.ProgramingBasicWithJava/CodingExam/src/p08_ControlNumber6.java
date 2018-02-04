import java.util.Scanner;

public class p08_ControlNumber6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int control = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= m ; i++) {
            for (int j = n; j >= 1; j--) {
                sum += (i * 2) + (j * 3);
                count++;
                if (sum >= control){
                    System.out.printf("%d moves%n", count);
                    System.out.printf("Score: %d >= %d", sum, control);
                    return;
                }
            }
        }
        System.out.printf("%d moves", count);
    }
}
