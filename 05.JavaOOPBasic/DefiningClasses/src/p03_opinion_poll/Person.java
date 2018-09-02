package p03_opinion_poll;

public class Person {
    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;
    private String name;
    private int age;

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return this.name;
    }


    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }
}

