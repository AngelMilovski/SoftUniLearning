package need_for_speed.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleInputReader() {
    }

    public static String readLine() {
        String result = null;

        try {
            result = reader.readLine();

        } catch (IOException e) { }

        return result;
    }
}
