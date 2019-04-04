import java.util.Scanner;

public class p03_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrixOfPalindrome = new String[rows][cols];

        for (int row = 0; row < matrixOfPalindrome.length; row++) {
            for (int col = 0; col < matrixOfPalindrome[row].length; col++) {
                String letters = getLetters(row, col);
                matrixOfPalindrome[row][col] = letters;
            }
        }
        printMatrix(matrixOfPalindrome);
    }

    private static void printMatrix(String[][] palindrome) {
        for (String[] col : palindrome) {
            for (String getValue : col) {
                System.out.print(getValue + " ");
            }
            System.out.println();
        }
    }

    private static String getLetters(int row, int col) {
        StringBuilder sb = new StringBuilder();
        int firstLetter = 'a' + row;
        sb.append((char) (firstLetter));
        int secondLetter = 'a' + (row + col);
        sb.append((char) secondLetter);
        int thirdLetter = 'a' + row;
        sb.append((char) thirdLetter);
        return sb.toString();
    }
}
