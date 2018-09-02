package p02_warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private List<Message> messages;
    private Importance importance;

    public Logger(Importance importance) {
        this.importance = importance;
        this.messages = new ArrayList<>();
    }

    public void record(Message message) {
        if (message.getLevel().compareTo(this.importance) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
