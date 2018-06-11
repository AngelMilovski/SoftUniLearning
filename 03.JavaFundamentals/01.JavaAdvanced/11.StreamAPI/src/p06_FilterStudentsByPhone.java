import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<Pair<String, String>> people = new ArrayList<>();
        String sfCode = "02";
        String bgPlusSfCode = "+3592";
        String input;
        while (true) {
            if ("END".equals(input = reader.readLine())) {
                break;
            }
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            String tel = tokens[2];
            Pair<String, String> person = new Pair<>(firstName + " " + lastName, tel);
            people.add(person);
        }

        people.stream()
                .filter(t -> t.getValue().startsWith(sfCode) || t.getValue().startsWith(bgPlusSfCode))
                .forEach(n -> {
                    System.out.println(String.format("%s", n.getKey()));
                });
    }
}