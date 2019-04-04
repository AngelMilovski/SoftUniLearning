import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p04_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int sizeOfRowAndCol = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[sizeOfRowAndCol][sizeOfRowAndCol];

        for (int i = 0; i < matrix.length; i++) {
            int[] col = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = col[j];
            }
        }
        int[] primaryDiagonal = getPrimaryDiagonal(matrix);
        int[] secondaryDiagonal = getSecondaryDiagonal(matrix);
        long sumAtThePrimaryDiagonal = 0;
        long sumAtTheSecondaryDiagonal = 0;
        for (int i = 0; i < primaryDiagonal.length; i++) {
            sumAtThePrimaryDiagonal += primaryDiagonal[i];
            sumAtTheSecondaryDiagonal += secondaryDiagonal[i];
        }
        long difference = Math.abs(sumAtThePrimaryDiagonal - sumAtTheSecondaryDiagonal);
        System.out.println(difference);
    }

    private static int[] getPrimaryDiagonal(int[][] matrix) {
        int[] primaryDiagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal[i] = matrix[i][i];
        }
        return primaryDiagonal;
    }

    private static int[] getSecondaryDiagonal(int[][] matrix) {
        int[] secondaryDiagonal = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonal[i] = matrix[i][(matrix.length - 1) - i];
        }
        return secondaryDiagonal;
    }

}
