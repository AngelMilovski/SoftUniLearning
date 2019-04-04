import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10_XBites {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int firstNum = Integer.parseInt(reader.readLine());
        int secondNum = Integer.parseInt(reader.readLine());
        int thirdNum = Integer.parseInt(reader.readLine());
        int fourthNum = Integer.parseInt(reader.readLine());
        int fifthNum = Integer.parseInt(reader.readLine());
        int sixthNum = Integer.parseInt(reader.readLine());
        int seventhNum = Integer.parseInt(reader.readLine());
        int eighthNum = Integer.parseInt(reader.readLine());

        String[] inputNumbersToBit = new String[]{Integer.toBinaryString(firstNum), Integer.toBinaryString(secondNum),
                Integer.toBinaryString(thirdNum), Integer.toBinaryString(fourthNum), Integer.toBinaryString(fifthNum),
                Integer.toBinaryString(sixthNum), Integer.toBinaryString(seventhNum), Integer.toBinaryString(eighthNum)};

        byte row = getLength(inputNumbersToBit);

        int[][] matrix = new int[8][row];

        matrix = InitializingTheMatrix(matrix, inputNumbersToBit);

        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i][j + 1] == 0) {
                        if (matrix[i][j + 2] == 1) {
                            if (matrix[i + 1][j] == 0) {
                                if (matrix[i + 1][j + 1] == 1) {
                                    if (matrix[i + 1][j + 2] == 0) {
                                        if (matrix[i + 2][j] == 1) {
                                            if (matrix[i + 2][j + 1] == 0) {
                                                if (matrix[i + 2][j + 2] == 1) {
                                                    count++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static byte getLength(String[] inputNumbersToBit) {
        byte longestLength = 0;

        for (int i = 0; i < inputNumbersToBit.length; i++) {
            byte length = getStringLength(inputNumbersToBit[i]);
            if (length > longestLength){
                longestLength = length;
            }
        }
        return longestLength;
    }

    private static byte getStringLength(String inputNumber) {
        byte count = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            count++;
        }
        return count;
    }

    private static int[][] InitializingTheMatrix(int[][] matrix, String[] inputNumbersToBit) {

        for (int i = 0; i < matrix.length; i++) {
            String currentNum = inputNumbersToBit[i];

            for (int j = 0; j < currentNum.length(); j++) {
                int currentChar = Integer.parseInt(Character.toString(currentNum.charAt(currentNum.length() - 1 - j)));
                matrix[i][matrix[i].length - 1 - j] = currentChar;
            }
        }
        return matrix;
    }
}