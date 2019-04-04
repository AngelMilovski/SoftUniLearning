import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11_SequenceInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] sizeOfMatrix = reader.readLine().split(" ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int cols = Integer.parseInt(sizeOfMatrix[1]);
        String[][] matrix = new String[rows][cols];
        if (rows == 0 || cols == 0) {
            return;
        }
        if (rows == 1 && cols == 1) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            String[] words = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = words[j];
            }
        }
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        String word = "";
        String[] sequence = getCol(matrix, rows, cols, count, maxCount, word);
        String result = String.join(", ", sequence);
        if (sequence.length < 1) {
            return;
        }
        System.out.println(result);
    }

    private static String[] getCol(String[][] matrix, int rows, int cols, int count, int maxCount, String word) {
        if (cols < 2) {
            String[] row = getRow(matrix, rows, cols, count, maxCount, word);
            return row;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])) {
                    count++;
                    if (count >= maxCount) {
                        maxCount = count;
                        word = matrix[i][j];
                    }
                } else {
                    count = 1;
                }
            }
            count = 1;
        }
        String[] col = new String[maxCount];
        for (int i = 0; i < maxCount; i++) {
            col[i] = word;
        }
        if (rows < 2) {
            return col;
        }
        String[] row = getRow(matrix, rows, cols, count, maxCount, word);
        if (row.length >= col.length) {
            return row;
        }
        return col;
    }

    private static String[] getRow(String[][] matrix, int rows, int cols, int count, int maxCount, String word) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - 1; j++) {
                String current = matrix[j][i];
                String next = matrix[j + 1][i];
                if (current.equals(next)) {
                    count++;
                    if (count >= maxCount) {
                        maxCount = count;
                        word = current;
                    }
                } else {
                    count = 1;
                }
            }
            count = 1;
        }
        String[] row = new String[maxCount];
        for (int i = 0; i < maxCount; i++) {
            row[i] = word;
        }
        if (rows > 1 && cols > 1) {
            String[] diagonal = getDiagonal(matrix, rows, cols, count, maxCount, word);
            if (diagonal.length > row.length) {
                return diagonal;
            }
        }
        return row;
    }

    private static String[] getDiagonal(String[][] matrix, int rows, int cols, int count, int maxCount, String word) {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                try {
                    if (matrix[i][j].equals(matrix[i + 1][j + 1])) {
                        int end = Math.min(rows - 1, cols - 1);
                        for (int k = i; k < end; k++) {
                            String current = matrix[k][k];
                            String next = matrix[k + 1][k + 1];
                            if (current.equals(next)) {
                                count++;
                                if (count >= maxCount) {
                                    maxCount = count;
                                    word = current;
                                }
                            } else {
                                break;
                            }
                        }
                        count = 1;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    count = 1;
                    continue;
                }
            }
        }
        String[] diagonal = new String[maxCount];
        for (int i = 0; i < maxCount; i++) {
            diagonal[i] = word;
        }
        return diagonal;
    }
}