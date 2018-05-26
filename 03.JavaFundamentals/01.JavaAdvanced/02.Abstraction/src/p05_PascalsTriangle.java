import java.math.BigInteger;
import java.util.Scanner;

public class p05_PascalsTriangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int height = Integer.parseInt(scan.nextLine());
        BigInteger[][] pascal = new BigInteger[height][];

        for (int i = 0; i < height; i++) {
            pascal[i] = new BigInteger[i + 1];
        }
        for (int row = 0; row < height; row++) {
            pascal[row][0] = (new BigInteger("1"));
            pascal[row][pascal[row].length - 1] = new BigInteger("1");
            for (int col = 1; col < pascal[row].length - 1; col++) {
                pascal[row][col] = pascal[row - 1][col - 1].add(pascal[row - 1][col]);
            }
        }

        for (BigInteger[] longs : pascal) {
            for (BigInteger num : longs) {

                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}