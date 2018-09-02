package person;

public class Person {
    private static final int NEEDED_NAME_LENGTH = 3;
    private static final int NEEDED_AGE = 1;

    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if (name.length() < NEEDED_NAME_LENGTH) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < NEEDED_AGE) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}
