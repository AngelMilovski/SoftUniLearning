import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p09_2To2SquaresInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] sizeOfTheMatrix = reader.readLine().split(" ");
        int row = Integer.parseInt(sizeOfTheMatrix[0]);
        int col = Integer.parseInt(sizeOfTheMatrix[1]);
        String[][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            String[] letters = reader.readLine().split(" ");
            for (int j = 0; j < letters.length; j++) {
                matrix[i][j] = letters[j];
            }
        }
        System.out.println(getCountOfSquareEqualsElements(matrix));
    }

    private static int getCountOfSquareEqualsElements(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])) {
                    if (matrix[i][j].equals(matrix[i + 1][j])){
                        if (matrix[i][j].equals(matrix[i + 1][j + 1])){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
