package p03_scale;

class Engine {
    private Scale<Integer> integerScale;
    private Scale<String> stringScale;
    private ConsoleOutputWriter writer;

    Engine() {
        this.integerScale = new Scale<>(1, 2);
        this.stringScale = new Scale<>("a", "c");
        this.writer = new ConsoleOutputWriter();
    }

     void run() {
        this.writer.readLine(String.format("%d%n%s", this.integerScale.getHeavier(), this.stringScale.getHeavier()));
    }
}
