package p02_define_class_person;

public class Person {
    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;
    private String name;
    private int age;

//    public Person() {
//        this.name = DEFAULT_NAME;
//        this.age = DEFAULT_AGE;
//    }
//
//    public Person(int age){
//        this();
//        this.age = age;
//    }
//
//    public Person(String name, int age) {
//        this(age);
//        this.name = name;
//    }

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Person(int age) {
        this(DEFAULT_NAME, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
