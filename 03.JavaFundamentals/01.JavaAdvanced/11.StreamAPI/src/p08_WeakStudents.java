import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p08_WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("\\s+",3);
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> grades = Arrays.stream(tokens[2].split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            String key = firstName + " " + lastName;
            students.putIfAbsent(key, grades);
        }
        students.entrySet().stream()
                .filter(x -> x.getValue().stream()
                .filter(s -> s <= 3).count() >= 2)
                .forEach(p -> System.out.println(p.getKey())
                );
    }
}
