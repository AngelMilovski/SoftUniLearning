package p05_generic_box;

import p05_generic_box.io.ConsoleInputReader;
import p05_generic_box.io.ConsoleOutputWriter;

import java.util.ArrayList;
import java.util.List;

class Engine {
    private List<Box> boxes;

    public Engine() {
        this.boxes = new ArrayList<>();
    }

    void run() {
        int n = Integer.parseInt(ConsoleInputReader.readLine());

        while (n-- > 0) {
            String line = ConsoleInputReader.readLine();
            Box<String> stringBox = new Box<>(line);
            this.boxes.add(stringBox);
        }

        boxes.forEach(ConsoleOutputWriter::writeLine);
    }
}
