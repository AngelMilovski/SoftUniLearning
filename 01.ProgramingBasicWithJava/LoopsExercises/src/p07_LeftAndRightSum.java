import java.util.Scanner;

public class p07_LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n * 2; i++){
            int currentNumber = Integer.parseInt(scan.nextLine());
            if (i < n){
                leftSum += currentNumber;
            }else {
                rightSum += currentNumber;
            }
        }
        if (leftSum == rightSum){
            System.out.println("Yes, sum = " + leftSum);
        }else {
            System.out.println("No, diff = " + (Math.abs(leftSum - rightSum)));
        }

    }
}
