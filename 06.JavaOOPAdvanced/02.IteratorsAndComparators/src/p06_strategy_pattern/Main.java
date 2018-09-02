package p06_strategy_pattern;

import p06_strategy_pattern.comparators.ComparatorByAge;
import p06_strategy_pattern.comparators.ComparatorByPersonName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private BufferedReader reader;
    private Set<Person> treeSetByName;
    private Set<Person> treeSetByAge;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.treeSetByName = new TreeSet<>(new ComparatorByPersonName());
        this.treeSetByAge = new TreeSet<>(new ComparatorByAge());
    }

    private void run() throws IOException {
        int n = Integer.parseInt(this.reader.readLine());

        while (n-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            this.treeSetByName.add(person);
            this.treeSetByAge.add(person);
        }

        this.treeSetByName.forEach(System.out::println);
        this.treeSetByAge.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        Main starter = new Main();
        starter.run();
    }
}
