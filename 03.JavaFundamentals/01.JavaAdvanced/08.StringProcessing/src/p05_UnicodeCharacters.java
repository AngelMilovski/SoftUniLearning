import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        char[] input = reader.readLine().toCharArray();

        for (char symbol : input) {
            System.out.printf("\\u%04x", (int) symbol);
        }
    }
}
