import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p07_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 1);
            } else {
                symbols.put(currentSymbol ,symbols.get(currentSymbol) + 1);
            }

        }
        for(Map.Entry<Character, Integer> ch : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", ch.getKey(), ch.getValue());
        }
    }
}