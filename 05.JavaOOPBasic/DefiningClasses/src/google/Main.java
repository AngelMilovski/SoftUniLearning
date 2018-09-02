package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<Person> people = new ArrayList<>();
        List<String> peopleNames = new ArrayList<>();
        String input;
        while (true) {
            if ("End".equals(input = reader.readLine())) {
                break;
            }
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            Person person;
            if (peopleNames.contains(name)) {
                person = people.stream().filter(x -> x.getName().equals(name)).findFirst().get();
            } else {
                person = new Person(name);
                people.add(person);
                peopleNames.add(name);
            }

            switch (tokens[1]) {

                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    person.setCompany(company);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    person.setCar(car);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    person.getParents().add(parent);
                    break;
                case "children":
                    Children children = new Children(tokens[2], tokens[3]);
                    person.getChildren().add(children);
                    break;
            }
        }
        String name = reader.readLine();
        people.stream().filter(x -> x.getName().equals(name)).forEach(System.out::println);

    }
}
