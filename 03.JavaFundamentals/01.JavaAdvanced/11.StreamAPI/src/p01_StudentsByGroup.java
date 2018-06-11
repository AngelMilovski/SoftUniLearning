import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class p01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String line;
        List<Students> students = new ArrayList<>();
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] studentData = line.split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int group = Integer.parseInt(studentData[2]);
            Students student = new Students(firstName, lastName, group);
            students.add(student);
        }

        students.stream()
                .filter(x -> x.getGroup() == 2)
                .sorted(Comparator.comparing(Students::getFirstName))
                .forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));

//        List<Integer> nums = new ArrayList() {{add(2); add(4);}};
//        Optional<Integer> match = nums.stream().findAny(x -> x % 2 == 0);
//        System.out.println(match);

    }
}

class Students {
    public String firstName;
    public String lastName;
    public int group;

    public Students(String firstName, String secondName, int group) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroup() {
        return group;
    }
}