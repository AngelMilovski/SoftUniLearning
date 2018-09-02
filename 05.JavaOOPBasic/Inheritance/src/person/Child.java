package person;

public class Child extends Person{
    private static final int NEEDED_AGE = 15;

    private String name;
    private Integer age;

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > NEEDED_AGE) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
