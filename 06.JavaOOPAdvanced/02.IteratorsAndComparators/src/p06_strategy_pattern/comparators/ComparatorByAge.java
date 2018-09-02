package p06_strategy_pattern.comparators;

import p06_strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    public ComparatorByAge() {
    }

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge() - secondPerson.getAge();
    }
}
