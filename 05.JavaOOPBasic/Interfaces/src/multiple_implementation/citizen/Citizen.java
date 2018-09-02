package multiple_implementation.citizen;

import multiple_implementation.interfaces.Birthable;
import multiple_implementation.interfaces.Identifiable;
import multiple_implementation.interfaces.Person;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final int getAge() {
        return this.age;
    }

    @Override
    public final String getBirthday() {
        return this.birthday;
    }

    @Override
    public final String getId() {
        return this.id;
    }
}
