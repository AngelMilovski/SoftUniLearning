package p06_generic_box_of_integer.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader reader = new BufferedReader(inputStreamReader);

    private ConsoleInputReader() {
    }

    public static String readLine() {
        String result = null;

        try {

            result = reader.readLine();

        } catch (IOException ex) {}

        return result;
    }
}
