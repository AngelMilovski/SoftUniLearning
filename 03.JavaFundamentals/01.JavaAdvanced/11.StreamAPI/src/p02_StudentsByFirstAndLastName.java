import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<People> listOfNames = new ArrayList<>();
        String input;
        while (true) {
            if ("END".equals(input = reader.readLine())) {
                break;
            }
            String[] namesData = input.split("\\s+");
            String firstName = namesData[0];
            String lastName = namesData[1];
            People names = new People(firstName, lastName);
            listOfNames.add(names);
        }

        listOfNames.stream()
                .filter(x -> x.getLastName().compareTo(x.getFirstName()) > 0)
                .forEach(System.out::println);

    }
}
class Pearson {
    public String firstName;
    public String lastName;

    public Pearson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getFirstName(), this.getLastName());
    }
}
