import java.util.Scanner;

public class p08_OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= n ; i++) {
            int currentNumber = Integer.parseInt(scan.nextLine());
            if (i % 2 == 1){
                oddSum += currentNumber;
            }else {
                evenSum += currentNumber;
            }
        }
        if (evenSum == oddSum){
            System.out.printf("Yes,%nSum = %d", evenSum);
        }else {
            System.out.printf("No,%nDiff = %d", (Math.abs(evenSum - oddSum)));
        }
    }
}



