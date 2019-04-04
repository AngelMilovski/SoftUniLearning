import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class p07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");
        BiPredicate<String, Integer> checker = (name, length) -> name.length() <= length;

        for (String name : names) {
            if (checker.test(name, n)) {
                System.out.println(name);
            }
        }
    }
}