import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p07_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] inputArr = reader.readLine().split(" ");
        Set<Character> firstWord = fillSet(inputArr[0]);
        Set<Character> secondWord = fillSet(inputArr[1]);
        System.out.println(firstWord.size() == secondWord.size() ? "true" : "false");
    }

    private static Set<Character> fillSet(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            set.add(current);
        }
        return set;
    }
}
