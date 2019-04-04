import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p17_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] data = reader.readLine().split("[\\\\\\/()\\s]");
        Pattern pattern = Pattern.compile("^[A-Za-z]\\w{2,24}$");
        List<String> usernames = new ArrayList<>();
        for (String user : data) {
            Matcher matcher = pattern.matcher(user);
            if (matcher.find()) {
                usernames.add(matcher.group());
            }
        }
        byte longestSum = Byte.MIN_VALUE;
        byte index = 0;
        for (byte i = 0; i < usernames.size() - 1; i++) {
            String current = usernames.get(i);
            String next = usernames.get(i + 1);
            byte sum = (byte)(current.length() + next.length());
            if (sum > longestSum) {
                longestSum = sum;
                index = i;
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(usernames.get(index + i));
        }
    }
}