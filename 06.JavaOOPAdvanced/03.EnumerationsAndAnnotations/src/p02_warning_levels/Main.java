package p02_warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Importance importance = Importance.valueOf(reader.readLine().toUpperCase());
        Logger logger = new Logger(importance);

        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int colonIndex = line.indexOf(":");
            String messageLevel = line.substring(0, colonIndex);
            String message = line.substring(colonIndex + 2);
            logger.record(new Message(Importance.valueOf(messageLevel), message));
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
