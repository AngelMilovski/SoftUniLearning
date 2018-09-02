package p03_opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] personArgs = reader.readLine().split(" ");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }

        persons.stream().filter(a -> a.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
