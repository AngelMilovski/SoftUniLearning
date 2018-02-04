import java.util.Scanner;

public class p35_Bottles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstPlayer = Integer.parseInt(scan.nextLine());
        int secondPlayer = Integer.parseInt(scan.nextLine());
        int maxNumberFighting = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 1; i <= firstPlayer; i++) {
            for (int j = 1; j <= secondPlayer; j++) {
                count++;
                if (count == maxNumberFighting){
                    System.out.print("" + "(" + i + " <-> " + j+ ")" + " ");
                    return;
                }
                System.out.print("" + "(" + i + " <-> " + j+ ")" + " ");
            }
        }

    }
}
