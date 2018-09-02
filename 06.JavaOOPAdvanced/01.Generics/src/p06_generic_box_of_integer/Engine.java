package p06_generic_box_of_integer;

import p06_generic_box_of_integer.io.ConsoleInputReader;
import p06_generic_box_of_integer.io.ConsoleOutputWriter;

import java.util.ArrayList;
import java.util.List;

class Engine {
    private List<Box> boxes;

    Engine() {
        this.boxes = new ArrayList<>();
    }

    void run() {
        int n = Integer.parseInt(ConsoleInputReader.readLine());

        while (n-- > 0) {
            int line = Integer.parseInt(ConsoleInputReader.readLine());
            Box<Integer> integerBox = new Box<>(line);
            this.boxes.add(integerBox);
        }

        boxes.forEach(ConsoleOutputWriter::writeLine);
    }
}
