import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12_CollectTheCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        char[][] board = new char[4][];
        for (int i = 0; i < 4; i++) {
            board[i] = reader.readLine().toCharArray();
        }
        int rowIndex = 0;
        int colIndex = 0;
        int coinCount = 0;
        int wallCount = 0;
        char coin = '$';
        char[] moves =  reader.readLine().toCharArray();
        for (int i = 0; i < moves.length; i++) {
            char move = moves[i];
            switch (move) {
                case 'V':
                    try {
                        char down = board[rowIndex + 1][colIndex];
                        rowIndex++;
                        if (down == coin) {
                            coinCount++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        wallCount++;
                    }
                    break;
                case '^':
                    try {
                        char up = board[rowIndex - 1][colIndex];
                        rowIndex--;
                        if (up == coin) {
                            coinCount++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        wallCount++;
                    }
                    break;
                case '>':
                    try {
                        char right = board[rowIndex][colIndex + 1];
                        colIndex++;
                        if (right == coin) {
                            coinCount++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        wallCount++;
                    }
                    break;
                case '<':
                    try {
                        char left = board[rowIndex][colIndex - 1];
                        colIndex--;
                        if (left == coin) {
                            coinCount++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        wallCount++;
                    }
                    break;
                    default:
                        break;
            }
        }
        System.out.println("Coins = " + coinCount);
        System.out.println("Walls = " + wallCount);
    }
}
