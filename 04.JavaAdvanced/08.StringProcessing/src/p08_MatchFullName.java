import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08_MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder result = new StringBuilder();
        String regex = "^([A-Z])([a-z])+([^\\t])([A-Z][a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        String name;

        while (true) {
            if ("end".equals(name = reader.readLine())) break;
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                result.append(matcher.group()).append(System.lineSeparator());
            }
        }
        System.out.println(result);
    }
}