import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p05_FilterStudentByEmailDomain {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String line;
        List<Students2> students = new ArrayList<>();
        String validDomain = "@gmail.com";
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] studentData = line.split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            String email = studentData[2];
            Students2 student = new Students2(firstName, lastName, email);
            students.add(student);
        }

        students.stream()
                .filter(x -> x.getEmail().endsWith(validDomain))
                .forEach(System.out::println);
    }
}

class Students2 {
    public String firstName;
    public String lastName;
    public String email;

    public Students2(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
