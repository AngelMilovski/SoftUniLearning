package need_for_speed.engines;


import need_for_speed.io.ConsoleInputReader;
import need_for_speed.utilities.InputParser;

import java.util.List;

public class Engine {
    private static final String TERMINATE_COMMAND = "Cops Are Here";

    public Engine() {

    }

    public void run() {
        String input;

        while (true) {
            input = ConsoleInputReader.readLine();
            if (TERMINATE_COMMAND.equalsIgnoreCase(input)) {
                break;
            }
            List<String> commandArgs = InputParser.inputParse(input);
            dispatchCommand(commandArgs);
        }
    }

    private void dispatchCommand(List<String> commandArgs) {

    }
}
