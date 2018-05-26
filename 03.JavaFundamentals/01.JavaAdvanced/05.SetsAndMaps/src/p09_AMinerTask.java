import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class p09_AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<String, Long> allResources = new LinkedHashMap<>();
        String line;
        int countLine = 1;
        String resource = "";
        while (true) {
            if ("stop".equals(line = reader.readLine())) {
                break;
            }

            if (countLine % 2 == 1) {
                resource = line;
            } else {
                long quantity = Long.parseLong(line);
                if (!allResources.containsKey(resource)) {
                    allResources.put(resource, (long) 0);
                }
                    allResources.put(resource, allResources.get(resource) + quantity);

                resource = "";
            }
            countLine++;
        }
        for (Map.Entry<String,Long> entry : allResources.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}