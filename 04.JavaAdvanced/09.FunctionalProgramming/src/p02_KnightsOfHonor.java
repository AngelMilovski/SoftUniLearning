import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p02_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(" ");
        Consumer<String[]> consumer = (names) -> {
            for (String name : names) {
                System.out.println("Sir " + name);
            }
        };
        consumer.accept(input);
    }
}