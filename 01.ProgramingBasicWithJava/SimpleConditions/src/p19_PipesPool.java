import java.text.DecimalFormat;
import java.util.Scanner;

public class p19_PipesPool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        int v = Integer.parseInt(scan.nextLine());
        int pipe1 = Integer.parseInt(scan.nextLine());
        int pipe2 = Integer.parseInt(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double p1 = pipe1 * h;
        double p2 = pipe2 * h;
        double totalFull = p1 + p2;


 //       int percentsPipeOne =(int) ((p1 / totalFull) * 100);
  //      int percentsPipeTwo =(int) ((p2 / totalFull) * 100);
  //      int percentsPoolFull =(int) ((totalFull / v) * 100);

        double percentsPipeOne = Math.floor((p1 / totalFull) * 100);
        double percentsPipeTwo = Math.floor((p2 / totalFull) * 100);
        double percentsPoolFull = Math.floor((totalFull / v) * 100);

        if ((totalFull) <= v) {
            System.out.printf("The pool is %s%% full. Pipe 1: %s%%. Pipe 2: %s%%.", df.format(percentsPoolFull), df.format(percentsPipeOne), df.format(percentsPipeTwo));
        } else {
            double overFlows = Math.abs(v - (p1 + p2));


            System.out.printf("For %s hours the pool overflows with %s liters.", h, df.format(overFlows));
        }
    }
}


