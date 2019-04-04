import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            sb.append(line).append(System.lineSeparator());
        }
        Pattern pattern = Pattern.compile("<a[^<>]+?href\\s*=\\s*(\\\".*?\\\"|'.*?'|.*?)[\\s>]");
        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()) {
            String values = matcher.group(1);
            if (values.startsWith("\"") || values.startsWith("'")) {
                values = values.substring(1, values.length() - 1);
            }
            System.out.println(values);
        }
    }
}