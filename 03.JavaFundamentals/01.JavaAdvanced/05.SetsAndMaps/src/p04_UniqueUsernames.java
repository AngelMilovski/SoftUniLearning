import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class p04_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int num = Integer.valueOf(reader.readLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            usernames.add(reader.readLine());
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
