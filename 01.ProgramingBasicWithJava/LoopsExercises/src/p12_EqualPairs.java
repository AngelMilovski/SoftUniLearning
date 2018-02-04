import java.util.Scanner;

public class p12_EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        int Sum = 0;
        int maxDiff = 0;
        int lastSum = 0;

        for (int i = 0; i < n; i++)
        {
            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());

            Sum = a + b;

            if (i > 0){
                int diff = Math.abs(Sum - lastSum);
                if (diff > maxDiff) maxDiff = diff;

            }
            lastSum = Sum;
        }
        System.out.println((maxDiff == 0) ?
                "Yes, value=" + Sum : "No, maxdiff=" + maxDiff);

    }
}


