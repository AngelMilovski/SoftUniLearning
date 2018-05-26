import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_MaximumSumOf2x2Submatrix {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            String[] numbers = reader.readLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        int[][] newMatrix = new int[2][2];
        int sum = 0;
        int theBiggestSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sum > theBiggestSum){
                    theBiggestSum = sum;
                    for (int k = 0; k < newMatrix.length; k++) {
                        for (int m = 0; m < newMatrix[k].length; m++) {
                             newMatrix[k][m] = matrix[i + k][j + m];
                        }

                    }
                }
            }

        }
        for (int[] cols : newMatrix) {
            for (int num : cols) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(theBiggestSum);
    }
}
