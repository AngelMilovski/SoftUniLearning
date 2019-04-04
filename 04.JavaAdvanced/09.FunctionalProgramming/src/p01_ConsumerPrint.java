import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(" ");

        Consumer<String[]> print = (inputEl) -> {
            for (String str : inputEl) {
                System.out.println(str);
            }
        };
        print.accept(input);
    }
}