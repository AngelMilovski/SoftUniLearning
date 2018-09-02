package p05_generic_box.io;

public class ConsoleOutputWriter {

    public ConsoleOutputWriter() {
    }

    public static <T> void writeLine(T output) {
        System.out.println(output);
    }
}
