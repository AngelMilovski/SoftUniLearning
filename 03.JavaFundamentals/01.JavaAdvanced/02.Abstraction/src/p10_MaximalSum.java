import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10_MaximalSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String[] sizeOfTheMatrix = reader.readLine().split(" ");
        int row = Integer.parseInt(sizeOfTheMatrix[0]);
        int col = Integer.parseInt(sizeOfTheMatrix[1]);
        if (row < 3 || col < 3){
            return;
        }
        int[][] matrix = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {
            String[] inputNumbers = reader.readLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(inputNumbers[j]);
            }
        }
        int[][] newMatrix = new int[3][3];
        long sum = 0;
        long theBiggestSum = Long.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > theBiggestSum) {
                    theBiggestSum = sum;
                    startRow = i;
                    startCol = j;
                    sum = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newMatrix[i][j] = matrix[startRow + i][startCol + j];
            }
        }
        System.out.println("Sum = " + theBiggestSum);
        for (int[] cols : newMatrix) {
            for (int num : cols) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}