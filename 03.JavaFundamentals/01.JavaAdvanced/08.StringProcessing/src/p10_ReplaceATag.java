import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p10_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if ("END".equals(input = reader.readLine())) {
                break;
            }
            sb.append(input).append(System.lineSeparator());
        }
        String html = sb.toString();
        html = html.replaceAll("<a\\s+href=([\\S\\s]*?)>([\\S\\s]*?)<\\/a>", "[URL href=$1]$2[/URL]");
        System.out.println(html);
    }
}