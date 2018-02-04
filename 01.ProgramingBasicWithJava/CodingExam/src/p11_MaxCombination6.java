import java.util.Scanner;

public class p11_MaxCombination6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int maxCombinations = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                count++;
                if (count > maxCombinations){
                    return;
                }
                System.out.printf("<%d-%d>", i, j);
            }
        }
    }
}
