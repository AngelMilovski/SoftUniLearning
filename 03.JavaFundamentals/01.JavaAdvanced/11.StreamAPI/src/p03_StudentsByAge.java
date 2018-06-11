import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String line;
        List<Student> names = new ArrayList<>();
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] pearsonData = line.split("\\s+");
            String firstName = pearsonData[0];
            String lastName = pearsonData[1];
            int age = Integer.parseInt(pearsonData[2]);
            Student student = new Student(firstName, lastName, age);
            names.add(student);
        }
        int minAge = 18;
        int maxAge = 24;
        names.stream()
                .filter(age -> age.getAge() >= minAge && age.getAge() <= maxAge)
                .forEach(System.out::println);
    }
}
class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.firstName, this.lastName, this.age);
    }
}