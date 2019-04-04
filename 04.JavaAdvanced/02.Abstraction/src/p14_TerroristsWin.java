import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p14_TerroristsWin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input = reader.readLine();
        char[] text = input.toCharArray();

        for (int i = 0; i < text.length; i++) {
            ArrayList<Character> symbolsFromTheText = new ArrayList<>();
            char current = text[i];
            int count = 0;
            int index = i;
            int sum = 0;
            if (current == '|') {
                try {
                    while (text[i + 1] != '|') {
                        symbolsFromTheText.add(text[i + 1]);
                        count++;
                        i++;
                        if (text[i + 1] == '|') {
                            i++;
                            for (int j = 0; j < symbolsFromTheText.size(); j++) {
                                int currentSymbol = symbolsFromTheText.get(j);
                                sum += currentSymbol;
                            }
                            break;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    continue;
                }
                if (sum > 0) {
                    int bombArea = sum % 10;
                    for (int j = 1; j <= bombArea; j++) {
                        if (index - j >= 0) {
                            text[index - j] = '.';
                        }
                        if ((index + count + 1) + j <= text.length - 1) {
                            text[(index + count + 1) + j] = '.';
                        }
                        i = (index + count + 1) + j;
                    }
                }
                int end = (index + 1) + count;
                for (int k = index; k <= end; k++) {
                    text[k] = '.';
                }
            }
        }
        printText(text);
    }

    private static void printText(char[] text) {
        for (char c : text) {
            System.out.print(c);
        }
        System.out.println();
    }
}