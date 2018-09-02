package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String[] studentTokens = reader.readLine().split(" ");
        String studentFirstName = studentTokens[0];
        String studentLastName = studentTokens[1];
        String facultyNumber = studentTokens[2];
        String[] workerTokens = reader.readLine().split(" ");
        String firstName = workerTokens[0];
        String lastName = workerTokens[1];
        double weekSalary = Double.parseDouble(workerTokens[2]);
        double workHoursPerDay = Double.parseDouble(workerTokens[3]);
        try {
            Human student = new Student(studentFirstName, studentLastName, facultyNumber);
            Human worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
