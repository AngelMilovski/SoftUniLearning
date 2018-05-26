import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split("\\s+");
        int col = Integer.parseInt(input[0]);
        int row = Integer.parseInt(input[1]);
        int[][] matrix = new int[col][row];
        for (int i = 0; i < matrix.length; i++) {
            String[] numbers = reader.readLine().split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        int startCol = 0;
        int startRow = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sum = getSum(matrix, i, j);
                if (sum > maxSum) {
                    maxSum = sum;
                    startCol = i;
                    startRow = j;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix, startCol, startRow);
        System.out.println();
    }

    private static void printMatrix(int[][] matrix, int startCol, int startRow) {
        for (int i = startCol; i <= startCol + 2; i++) {
            for (int j = startRow; j <= startRow + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int col, int row) {
        int sum = 0;
        for (int i = col; i <= col + 2; i++) {
            for (int j = row; j <= row + 2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
