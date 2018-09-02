package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        String ferrariNme = Ferrari.class.getSimpleName();
        String carName = Car.class.getSimpleName();
        boolean isCreate = Car.class.isInterface();

        if (!isCreate) {
            throw new IllegalClassFormatException("No interface created!");
        }
        print();
    }

    private static void print() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String driver = reader.readLine();
        Car ferrari = new Ferrari(driver);
        System.out.println(ferrari);
    }
}
