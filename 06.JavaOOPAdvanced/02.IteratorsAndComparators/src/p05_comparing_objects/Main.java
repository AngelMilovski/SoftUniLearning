package p05_comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private BufferedReader reader;

    private List<Person> people;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.people = new ArrayList<>();
    }

    public final void run() throws IOException {
        for (String line = this.reader.readLine(); !line.equals("END"); line = this.reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            this.people.add(person);
        }
        int n = Integer.parseInt(this.reader.readLine());

        if (n < 0 || n >= this.people.size()) {
            System.out.println("No matches");
            return;
        }

        Person person = this.people.get(n);

        long countOfEqualsPeople = this.people
                .stream()
                .filter(person1 -> person1.compareTo(person) == 0)
                .count();

        print(countOfEqualsPeople);
    }

    private void print(long countOfEqualsPeople) {
        if (countOfEqualsPeople != 0) {
            System.out.println(String.format("%d %d %d",
                    countOfEqualsPeople,
                    this.people.size() - countOfEqualsPeople,
                    this.people.size()));
        } else {
            System.out.println("No matches");
        }
    }

    public static void main(String[] args) throws IOException {
        Main starter = new Main();
        starter.run();
    }
}
