import java.util.Scanner;

public class p10_HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int biggestNumber = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scan.nextLine());
            sum = sum + currentNumber;
            if (currentNumber > biggestNumber) {
                biggestNumber = currentNumber;
            }
        }
        int diff = Math.abs(sum - biggestNumber);
        if (diff == biggestNumber) {
            System.out.printf("Yes%nSum = %d", biggestNumber);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(diff - biggestNumber));
        }

    }

}

