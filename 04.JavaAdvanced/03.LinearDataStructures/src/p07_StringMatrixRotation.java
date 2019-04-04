import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class p07_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split("[)(]");
        int degrees = Integer.parseInt(input[1]);
        int numberRotation = (degrees % 360) / 90;
        String line;
        List<String> matrixElements = new ArrayList<>();
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            matrixElements.add(line);
        }
        int numberOfElements = matrixElements.size();

        int longestElement = getLongestNumberOfElements(matrixElements);
        char[][] matrix = new char[numberOfElements][longestElement];

        for (int i = 0; i < matrix.length; i++) {
            String element = matrixElements.get(i);
            try {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = element.charAt(j);
                }
            } catch (StringIndexOutOfBoundsException ex) {
                continue;
            }
        }

        if (numberRotation == 0) {
            printMatrix(matrix);
            return;
        }
        matrix = rotateMatrix(matrix, longestElement, numberOfElements, numberRotation);
        printMatrix(matrix);
    }

    private static int getLongestNumberOfElements(List<String> matrixElements) {
        int longestElement = 0;
        for (int i = 0; i < matrixElements.size() - 1; i++) {
            int current = matrixElements.get(i).length();
            int next = matrixElements.get(i + 1).length();
            int result = Math.max(current, next);
            if (longestElement < result) {
                longestElement = result;
            }
        }
        return longestElement;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char letter : chars) {
                if (letter != '\u0000') {
                    System.out.print(letter);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int longestElement, int numberOfElements, int numberRotation) {
        switch (numberRotation) {
            case (1):
                char[][] rotate90Degrees = new char[longestElement][numberOfElements];
                for (int i = 0; i < numberOfElements; i++) {
                    for (int j = 0; j < longestElement; j++) {
                        rotate90Degrees[j][i] = matrix[numberOfElements - 1 - i][j];
                    }
                }
                return rotate90Degrees;
            case (2):
                char[][] rotate180Degrees = new char[numberOfElements][longestElement];
                for (int i = 0; i < rotate180Degrees.length; i++) {
                    for (int j = 0; j < rotate180Degrees[i].length; j++) {
                        rotate180Degrees[i][j] = matrix[numberOfElements - 1 - i][longestElement - 1 - j];
                    }
                }
                return rotate180Degrees;
            case (3):
                char[][] rotate270Degrees = new char[longestElement][numberOfElements];
                for (int i = 0; i < numberOfElements; i++) {
                    for (int j = 0; j < longestElement; j++) {
                        rotate270Degrees[j][i] = matrix[i][longestElement - 1 - j];
                    }
                }
                return rotate270Degrees;
        }
        return matrix;
    }
}
