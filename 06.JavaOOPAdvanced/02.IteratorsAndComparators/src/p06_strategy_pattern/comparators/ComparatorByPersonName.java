package p06_strategy_pattern.comparators;

import p06_strategy_pattern.Person;

import java.util.Comparator;

public class ComparatorByPersonName implements Comparator<Person> {

    public ComparatorByPersonName() { }

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int compareByNameLength = firstPerson.getName().length() - secondPerson.getName().length();
        if (compareByNameLength != 0) {
            return compareByNameLength;
        }

        return String.valueOf(firstPerson.getName().charAt(0))
                .compareToIgnoreCase(String.valueOf(secondPerson.getName().charAt(0)));
    }
}
