import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();
        for (int i = 0; i < bannedWords.length; i++) {
            text = text.replaceAll(bannedWords[i], repeatStr(bannedWords[i].length()));
        }
        System.out.println(text);
    }

    private static String repeatStr(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
             sb.append("*");
        }
        return sb.toString();
    }
}
