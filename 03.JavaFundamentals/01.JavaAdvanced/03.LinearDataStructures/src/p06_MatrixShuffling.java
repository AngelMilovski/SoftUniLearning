import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] sizeOnMatrix = reader.readLine().split(" ");
        int rows = Integer.parseInt(sizeOnMatrix[0]);
        int cols = Integer.parseInt(sizeOnMatrix[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reader.readLine().split(" ");
        }
        String[] data = reader.readLine().split(" ");
        while (!data[0].equals("END")) {
            if (!data[0].equals("swap") || data.length < 5 || data.length > 5) {
                System.out.println("Invalid input!");
                data = reader.readLine().split(" ");
                continue;
            }
            int row1 = Integer.parseInt(data[1]);
            int col1 = Integer.parseInt(data[2]);
            int row2 = Integer.parseInt(data[3]);
            int col2 = Integer.parseInt(data[4]);
            try {
                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
                printMatrix(matrix);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid input!");
            }
            data = reader.readLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] col : matrix) {
            for (String s : col) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
