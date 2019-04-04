import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class p07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input;
        Map<String, String> pupil = new LinkedHashMap<>();
        while (true) {
            if ("END".equals(input = reader.readLine())) {
                break;
            }
            String[] tokens = input.split("\\s+",3);
            String firstName = tokens[0];
            String lastName = tokens[1];
            String grades = tokens[2];
            String key = firstName + " " + lastName;
            pupil.put(key, grades);
        }
        pupil.entrySet().stream()
                .filter(x -> x.getValue().contains("6"))
                .forEach(n -> System.out.println(String.format("%s", n.getKey())));

    }
}
