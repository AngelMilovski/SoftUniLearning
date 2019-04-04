import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Pattern pattern = Pattern.compile("^\\+359(\\s{1}|-{1})\\d(\\1)\\d{3}(\\1)\\d{4}$");
        StringBuilder result = new StringBuilder();
        String phoneNumber;
        while (true) {
            if ("end".equals(phoneNumber = reader.readLine())) {
                break;
            }
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.find()) {
                result.append(matcher.group()).append(System.lineSeparator());
            }
        }
        System.out.println(result.toString());
    }
}
