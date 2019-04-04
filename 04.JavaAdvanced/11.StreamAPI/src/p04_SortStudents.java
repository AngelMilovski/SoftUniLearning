import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p04_SortStudents {
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
                .sorted((b1, b2) -> {
                int comp1 = b1.getLastName().compareTo(b2.getLastName());
                    if (comp1 != 0) {
                        return comp1;
                    }
                    return b2.getFirstName().compareTo(b1.firstName);
                })
//                .sorted(Comparator.comparing(People::getLastName).thenComparing(Comparator.comparing(People::getFirstName).reversed()))
                  .forEach(System.out::println);

        }
    }

class People {
    public String firstName;
    public String lastName;

    public People(String firstName, String lastName) {
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