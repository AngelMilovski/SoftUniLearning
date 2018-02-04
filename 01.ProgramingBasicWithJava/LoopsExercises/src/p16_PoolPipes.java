import java.util.Scanner;

public class p16_PoolPipes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vPool = Integer.parseInt(scan.nextLine());
        int pipeOne = Integer.parseInt(scan.nextLine());
        int pipeTwo = Integer.parseInt(scan.nextLine());
        double hWithoutAWorker = Double.parseDouble(scan.nextLine());

        double pipe1 = pipeOne * hWithoutAWorker;
        double pipe2 = pipeTwo * hWithoutAWorker;
        double totalFull = pipe1 + pipe2;

        if (totalFull <= vPool){
            int percentOfTotalFull = (int)((totalFull / vPool) * 100);
            int percentOfPipeOne = (int)((pipe1 / totalFull) * 100);
            int percentOfPipeTwo = (int)((pipe2 / totalFull) * 100);


            System.out.printf("The pool is %d%% full. Pipe 1: %d%% Pipe 2: %d%%", percentOfTotalFull, percentOfPipeOne,percentOfPipeTwo);
        }else {
            double overFlows = Math.abs(totalFull - vPool);

            System.out.printf("For %s hours the pool overflows with %.1f liters.", hWithoutAWorker, overFlows);
        }
    }
}
