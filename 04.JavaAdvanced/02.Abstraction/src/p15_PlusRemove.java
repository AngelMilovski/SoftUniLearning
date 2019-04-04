import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class p15_PlusRemove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input = reader.readLine();
        ArrayList<String> textLines = new ArrayList<>();
        while (!input.equals("END")) {
            textLines.add(input);
            input = reader.readLine();
        }

        char[][] textSymbols = new char[textLines.size()][];
        for (int i = 0; i < textSymbols.length; i++) {
            textSymbols[i] = textLines.get(i).toLowerCase().toCharArray();
        }

        int count = 0;
        int index = -1;
        ArrayList<ArrayList<Character>> finalMatrix = new ArrayList<>();
        ArrayList<Character> addSymbols = new ArrayList<>();
        for (int i = 0; i < textSymbols.length - 2; i++) {

            for (int j = 1; j <= textSymbols.length; j++) {
                try {
                    char top = textSymbols[i][j];
                    char leftDown = textSymbols[i + 1][j - 1];
                    char middleDown = textSymbols[i + 1][j];
                    char rightDown = textSymbols[i + 1][j + 1];
                    char bottom = textSymbols[i + 2][j];
                    if (top == leftDown && top == middleDown && top == rightDown && top == bottom) {
                       addSymbols.add(textSymbols[i][j]);
                    } else {
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    addSymbols.add(textSymbols[i][j]);
                    continue;
                }

            }
            finalMatrix.add(addSymbols);
            addSymbols.clear();
        }
        printMatrix(textSymbols);
//        for (ArrayList<Character> matrix : finalMatrix) {
//            for (Character character : matrix) {
//                System.out.print(character);
//            }
//            System.out.println();
//        }
    }

    private static void printMatrix(char[][] textSymbols) {
        for (char[] textSymbol : textSymbols) {
            for (char c : textSymbol) {
                if (c != 0) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}

//abb*l5
//bBbB555
//abbh*5
//ttHHH
//ttth
//END