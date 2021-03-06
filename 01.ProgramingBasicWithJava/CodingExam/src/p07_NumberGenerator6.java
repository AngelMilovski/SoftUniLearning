import java.util.Scanner;

public class p07_NumberGenerator6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        int special = Integer.parseInt(scan.nextLine());
        int control = Integer.parseInt(scan.nextLine());

        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                for (int k = l; k >= 1; k--) {
                    int mnl = i * 100 + j * 10 + k;

                    if (mnl % 3 == 0) {
                        special += 5;
                    }
                    else if(mnl % 10 == 5){
                        special -= 2;
                    }
                    else if (mnl % 2 == 0){
                        special *= 2;
                    }
                    if (special >= control) {
                        System.out.printf("Yes! Control number was reached! Current special number is %d.", special);
                        return;
                    }
                }
            }
        }
        System.out.printf("No! %d is the last reached special number.", special);
    }
}
