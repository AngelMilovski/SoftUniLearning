import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int maxDiff = 0;
        int lastSum = 0;

        for (int i = 0; i < n; i++){
            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());

            sum = a + b;

            if (i > 0){
                int diff = Math.abs(sum - lastSum);
                    if (diff > maxDiff) maxDiff = diff;
                }
            lastSum = sum;
            }

                 System.out.println((maxDiff == 0) ?
                "Yes, value= " + sum : "No, maxdiff=" + maxDiff);


    }

    }

