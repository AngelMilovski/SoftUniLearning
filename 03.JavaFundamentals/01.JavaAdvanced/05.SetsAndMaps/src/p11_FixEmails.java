import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p11_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String line = "";
        Map<String, String> emails = new LinkedHashMap<>();
        String name = "";
        byte countLine = 1;
        while (true) {
            if ("stop".equals(line = reader.readLine())) {
                break;
            }
            if (countLine % 2 == 1) {
                name = line;
                countLine++;
            } else {
                if (line.contains(".bg")) {
                    emails.put(name, line);
                }
                countLine++;
            }
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
