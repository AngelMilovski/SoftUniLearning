import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class p11_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String line = "";
        line += reader.readLine();


        Pattern patternEmail = Pattern.compile("(^|\\s)[\\dA-Za-z][\\w\\-.]+?[\\dA-Za-z]@[A-Za-z][A-Za-z\\-]*(\\.[A-Za-z]+)+");
        java.util.regex.Matcher matcher = patternEmail.matcher(line);
        while(matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}