package p02_warning_levels;

public class Message {


    private Importance level;
    private String message;

    public Message(Importance level, String message) {
        this.level = level;
        this.message = message;
    }

    public Importance getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.level, this.message);
    }

}
