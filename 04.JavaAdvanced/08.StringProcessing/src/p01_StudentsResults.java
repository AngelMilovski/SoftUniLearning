import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input = reader.readLine();
        String[] data = input.split(" - ");
        String student = data[0];
        String[] result = data[1].split(", ");
        double jAdv = Double.valueOf(result[0]);
        double javaOOP = Double.valueOf(result[0]);
        double advOOP = Double.valueOf(result[0]);
        double average = 0.0d;
        for (int i = 0; i < result.length; i++) {

            average += Double.valueOf(result[i]);
        }
        average /= 3;
        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|","name","JAdv", "JavaOOP", "AdvOOP", "Average"));
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", student, jAdv, javaOOP, advOOP, average));
    }
}
