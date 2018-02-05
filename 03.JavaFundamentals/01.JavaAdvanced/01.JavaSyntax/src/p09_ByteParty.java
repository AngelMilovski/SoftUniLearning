import java.util.*;

public class p09_ByteParty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][8];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            String bit = Integer.toBinaryString(number);
            String reversedBitNumber = reverseBitNumber(bit);
            if (bit.length() < 8) {
                int size = 8 - bit.length();
                for (int j = 0; j < size; j++) {
                    reversedBitNumber += '0';
                }
            }
            reversedBitNumber = reverseBitNumber(reversedBitNumber);
            for (int j = 0; j < reversedBitNumber.length(); j++) {
                matrix[i][j] = reversedBitNumber.charAt(j);
            }
        }

        String commands = scan.nextLine();
        while (!commands.equals("party over")) {
            if (commands.equals("party over")) {
                break;
            }
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            int position = Math.abs(Integer.parseInt(tokens[1]) - 7);
            switch (command) {
                case "-1":
                    for (int i = 0; i < n; i++) {
                        matrix[i][position] = matrix[i][position] == '0' ? '1' : '0';
                    }
                    break;
                case "0":
                    for (int i = 0; i < n; i++) {
                        matrix[i][position] = '0';
                    }
                    break;
                case "1":
                    for (int i = 0; i < n; i++) {
                        matrix[i][position] = '1';
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        printNumber(matrix, n);
    }

    private static String reverseBitNumber(String bit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bit.length(); i++) {
            sb.append(bit.charAt(i));
        }
        sb.reverse();
        return sb.toString();
    }

    private static void printNumber(char[][] matrix, int col) {
        for (int i = 0; i < col; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[col - 1].length; j++) {
                sb.append(matrix[i][j]);
            }
            System.out.println(Integer.parseInt(sb.toString(), 2));
        }
    }
}