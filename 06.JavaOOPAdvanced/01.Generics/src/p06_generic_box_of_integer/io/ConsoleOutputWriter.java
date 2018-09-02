package p06_generic_box_of_integer.io;

public class ConsoleOutputWriter {

    private ConsoleOutputWriter() {
    }

    public static <T> void writeLine(T output) {
        System.out.println(output);
    }
}
