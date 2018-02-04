import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int controlNumber = Integer.parseInt(scan.nextLine());
        int count = 0;


        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                for (int k = 1; k <= 30; k++) {
                    if (i < j && j < k && i + j + k == controlNumber) {
                        count++;
                        System.out.println("" + i + " + " + j + " + " + k + " = " + controlNumber + " ");

                    } else if (i > j && j > k && i * j * k == controlNumber) {
                        count++;
                        System.out.println("" + i + " * " + j + " * " + k + " = " + controlNumber + " ");
                        break;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("No!");
        }
    }
}

