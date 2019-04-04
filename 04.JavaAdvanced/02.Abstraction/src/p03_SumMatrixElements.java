import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class p03_SumMatrixElements {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int[] rowAndCol = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int row = rowAndCol[0];
        int col = rowAndCol[1];
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        long sum = 0;
        for (int[] rows : matrix) {
            for (int num : rows) {
                sum += num;
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
}
