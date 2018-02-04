import java.util.Scanner;

public class p13_Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double numbersP1 = 0;
        double numbersP2 = 0;
        double numbersP3 = 0;
        double numbersP4 = 0;
        double numbersP5 = 0;

        for (int i = 0; i < n; i++){
            int currentNumber = Integer.parseInt(scan.nextLine());
            if (currentNumber < 200) {
                numbersP1 += 1;
            } else if (currentNumber >= 200 && currentNumber <= 399) {
                numbersP2 += 1;
            } else if (currentNumber >= 400 && currentNumber <= 599) {
                numbersP3 += 1;
            } else if (currentNumber >= 600 && currentNumber <= 799) {
                numbersP4 += 1;
            }else if (currentNumber >= 800){
                numbersP5 += 1;
            }
        }
        System.out.printf("%.2f%%%n", ((numbersP1 / n) * 100));
        System.out.printf("%.2f%%%n", ((numbersP2 / n) * 100));
        System.out.printf("%.2f%%%n", ((numbersP3 / n) * 100));
        System.out.printf("%.2f%%%n", ((numbersP4 / n) * 100));
        System.out.printf("%.2f%%%n", ((numbersP5 / n) * 100));
    }
}