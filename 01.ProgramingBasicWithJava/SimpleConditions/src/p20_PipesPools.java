import java.util.Scanner;

public class p20_PipesPools {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double v = Double.parseDouble(scan.nextLine());
        double p1 = Double.parseDouble(scan.nextLine());
        double p2 = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double waterPipe1 = h * p1;
        double waterPipe2 = h * p2;

        if (waterPipe1 + waterPipe2 <= v) {
            double percentageOfOneLiterPool = 100 / v;
            double percentageFully = (waterPipe1 + waterPipe2) * percentageOfOneLiterPool;

            int percentatgeOfOneLiterPipe =(int) (100 / (waterPipe1 + waterPipe2));
            double firstPipe = percentatgeOfOneLiterPipe * waterPipe1;
            double secondPipe = percentatgeOfOneLiterPipe * waterPipe2;

            percentageFully = Math.floor(percentageFully);
            firstPipe = Math.floor(firstPipe);
            secondPipe = Math.floor(secondPipe);

            System.out.printf("The pool is %d%% full. Pipe 1: %d%%. Pipe 2: %d%%.", percentageFully, firstPipe, secondPipe);
        } else {
            double moreLiters = (waterPipe1 + waterPipe2) - v;

            System.out.printf("For %s hours the pool overflows with %.1f liters.", h, moreLiters);
        }

    }
}
