import java.text.DecimalFormat;
        import java.util.Scanner;

public class p11_OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        int n = Integer.parseInt(scan.nextLine());
        double evenSum = 0.0;
        double oddSum = 0.0;
        double evenMax = -10000000000000.0;
        double evenMin = 100000000000000.0;
        double oddMax = -10000000000000000.0;
        double oddMin = 10000000000000000.0;

        for (int i = 0; i < n; i++) {
            double currentNumber = Double.parseDouble(scan.nextLine());
            if (i % 2 == 1) {
                evenSum = evenSum + currentNumber;
                if (currentNumber < evenMin) {
                    evenMin = currentNumber;
                }
                if (currentNumber > evenMax) {
                    evenMax = currentNumber;
                }

            } else {
                oddSum = oddSum + currentNumber;
                if (currentNumber < oddMin) {
                    oddMin = currentNumber;
                }
                if (currentNumber > oddMax) {
                    oddMax = currentNumber;
                }
            }
        }
        if (n == 0) {
            System.out.println("OddSum = " + df.format(evenSum));
            System.out.println("OddMin = No");
            System.out.println("OddMax = No");
            System.out.println("EvenSum = " + df.format(oddSum));
            System.out.println("EvenMin = No");
            System.out.println("EvenMax = No");
        } else if (n == 1) {
            System.out.println("OddSum = " + df.format(evenSum));
            System.out.println("OddMin = " + df.format(evenMin));
            System.out.println("OddMax = " + df.format(evenMax));
            System.out.println("EvenSum = " + df.format(oddSum));
            System.out.println("EvenMin = No");
            System.out.println("EvenMax = No");
        } else {
            System.out.println("OddSum = " + df.format(evenSum));
            System.out.println("OddMin = " + df.format(evenMin));
            System.out.println("OddMax = " + df.format(evenMax));
            System.out.println("EvenSum = " + df.format(oddSum));
            System.out.println("EvenMin = " + df.format(oddMin));
            System.out.println("EvenMax = " + df.format(oddMax));

        }
    }
}




