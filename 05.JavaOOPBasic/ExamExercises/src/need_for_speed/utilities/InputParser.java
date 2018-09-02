package need_for_speed.utilities;


import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {

    public InputParser() {
    }

    public static ArrayList<String> inputParse(String input) {
        return new ArrayList<String>(Arrays.asList(input.split("\\s+")));

    }
}