package person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        reader.close();
        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
            System.out.println(personClassName);
            System.out.println(childClassName);
        } catch (IllegalArgumentException iao) {
            System.out.println(iao.getMessage());
        }
    }
}
