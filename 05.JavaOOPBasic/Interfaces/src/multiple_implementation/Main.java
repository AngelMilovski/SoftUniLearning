package multiple_implementation;

import multiple_implementation.citizen.Citizen;
import multiple_implementation.interfaces.Birthable;
import multiple_implementation.interfaces.Identifiable;
import multiple_implementation.interfaces.Person;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner scan = new Scanner(System.in);
            String name = scan.nextLine();
            int age = Integer.parseInt(scan.nextLine());
            String id = scan.nextLine();
            String birthday = scan.nextLine();
            Identifiable identifiable = new Citizen(name, age, id, birthday);
            Birthable birthable = new Citizen(name, age, id, birthday);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());

        }
    }
}
