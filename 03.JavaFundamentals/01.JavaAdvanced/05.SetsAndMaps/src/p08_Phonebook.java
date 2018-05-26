import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;


public class p08_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String command;
        Map<String, String> phonebook = new LinkedHashMap<>();
        while (true) {
            if ("search".equals(command = reader.readLine())) {
                break;
            }
            String[] tokens = command.split("-");
            String name = tokens[0];
            String phone = tokens[1];

            phonebook.put(name, phone);


        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if ("stop".equals(command = reader.readLine())) {
                break;
            }

            if (phonebook.containsKey(command)) {
                String test = phonebook.keySet().toString().replaceAll("[\\[\\]]", "");
                sb.append(String.format("%s -> %s", getKey(phonebook, command), phonebook.get(command)))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format("Contact %s does not exist.", command)).append(System.lineSeparator());
            }

        }
        System.out.println(sb.toString());
    }

    private static String getKey(Map<String, String> phonebook, String command) {
        if (phonebook.containsKey(command)) {
            return command;
        }
        return null;
    }
}
