import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String text = reader.readLine().toLowerCase();
        String searchString = reader.readLine().toLowerCase();
        int index = text.indexOf(searchString);
        int count = 0;
        while (true) {
            if (index >= 0) {
                index += 1;
                count++;
                index = text.indexOf(searchString, index);
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}