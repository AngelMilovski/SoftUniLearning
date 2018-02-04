import java.util.Scanner;

public class p14_PartitionWithoutResidue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double percentWithoutResidue2 = 0.0;
        double percentWithoutResidue3 = 0.0;
        double percentWithoutResidue4 = 0.0;

        for (int i = 0; i < n; i++){
            int currentNumber = Integer.parseInt(scan.nextLine());
            if (currentNumber % 2 == 0){
                percentWithoutResidue2++;
            } if (currentNumber % 3 == 0){
                percentWithoutResidue3++;
            } if (currentNumber % 4 == 0){
                percentWithoutResidue4++;
            }
        }
        System.out.printf("%.2f%%%n", ((percentWithoutResidue2 / n) * 100));
        System.out.printf("%.2f%%%n", ((percentWithoutResidue3 / n) * 100));
        System.out.printf("%.2f%%%n", ((percentWithoutResidue4 / n) * 100));
    }
}
