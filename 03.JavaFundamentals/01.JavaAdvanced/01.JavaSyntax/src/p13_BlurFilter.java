import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p13_BlurFilter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        int blurAmount = Integer.parseInt(reader.readLine());
        String[] pixelWeight = reader.readLine().split("\\s+");
        byte col = Byte.parseByte(pixelWeight[0]);
        byte row = Byte.parseByte(pixelWeight[1]);
        long[][] matrix = new long[col][row];

        for (int i = 0; i < col; i++) {
            int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < row; j++) {
                matrix[i][j] = numbers[j];
            }
        }
        String[] coordinatesOfTheBlur = reader.readLine().split("\\s+");
        int startCol = Integer.parseInt(coordinatesOfTheBlur[0]);
        int startRow = Integer.parseInt(coordinatesOfTheBlur[1]);

        matrix[startCol][startRow] += blurAmount;
        if (startRow + 1 < row) {
            matrix[startCol][startRow + 1] += blurAmount;
            if (startCol + 1 < col) {
                matrix[startCol + 1][startRow + 1] += blurAmount;
            }
        }
        if (startRow - 1 >= 0) {
            matrix[startCol][startRow - 1] += blurAmount;
            if (startCol - 1 >= 0) {
                matrix[startCol - 1][startRow - 1] += blurAmount;
            }
        }
        if (startCol + 1 < col) {
            matrix[startCol + 1][startRow] += blurAmount;
            if (startRow - 1 >= 0) {
                matrix[startCol + 1][startRow - 1] += blurAmount;
            }
        }
        if (startCol - 1 >= 0) {
            matrix[startCol - 1][startRow] += blurAmount;
            if (startRow + 1 < row) {
                matrix[startCol - 1][startRow + 1] += blurAmount;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}