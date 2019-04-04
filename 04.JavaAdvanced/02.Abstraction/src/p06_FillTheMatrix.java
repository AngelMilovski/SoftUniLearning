import java.util.Scanner;

public class p06_FillTheMatrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            matrix = getMatrixA(matrix, n);
        } else if (pattern.equals("B")) {
            matrix = getMatrixB(matrix, n);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int num : rows) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixA(int[][] matrix, int n) {
        int[][] matrixA = new int[n][n];
        int row = 0;
        for (int i = 0; i < matrixA.length; i++) {
            row++;
            int col = row;
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] = col;
                col += matrixA.length;
            }
        }
        return matrixA;
    }

    private static int[][] getMatrixB(int[][] matrix, int n) {
        int[][] matrixB = new int[n][n];
        int row = 1;
        for (int i = 0; i < matrixB[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrixB.length; j++) {
                    matrixB[j][i] = row;
                    row++;
                }
            } else {
                for (int j = 0; j < matrixB.length; j++) {
                    matrixB[matrixB[0].length - 1 - j][i] = row;
                    row++;
                }
            }
        }
        return matrixB;
    }
}
