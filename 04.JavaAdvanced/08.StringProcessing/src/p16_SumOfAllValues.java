import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String keysString = reader.readLine();
        Pattern patternKeys = Pattern.compile("^([A-Za-z_]+)?\\d+.*\\d([A-Za-z_]+)$");
        Matcher keysMatcher = patternKeys.matcher(keysString);
        String start = "";
        String end = "";
        if (keysMatcher.find()) {
            start = keysMatcher.group(1);
            end = keysMatcher.group(2);
            String text = reader.readLine();
            Pattern textPattern = Pattern.compile(start + "(\\d*(\\.\\d+)*)" + end);
            Matcher matcher = textPattern.matcher(text);
            double sum = 0.0d;
            while (matcher.find()) {
                if (!matcher.group(1).isEmpty()) {
                    sum += Double.parseDouble(matcher.group(1));
                }
            }
            if (sum == 0.0) {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            } else {
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println(String.format("<p>The total value is: <em>%s</em></p>", df.format(sum)));
            }
        } else {
            //No key
            System.out.println("<p>A key is missing</p>");
            return;
        }
    }
}