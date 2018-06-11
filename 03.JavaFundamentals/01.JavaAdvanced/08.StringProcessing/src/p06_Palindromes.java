import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.TreeSet;

public class p06_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] text = reader.readLine().split("[,?\\s+!.]+");
        Set<String> palindromes = new TreeSet<>();
        for (String s : text) {
            if (s.length() == 1) {
                palindromes.add(s);
            } else {
                if (isPalindrome(s)) {
                    palindromes.add(s);
                }
            }
        }
        System.out.println(palindromes);
    }

    private static boolean isPalindrome(String s) {
        ArrayDeque<Character> arr = new ArrayDeque<>();
        for (int i = 0; i < s.length() / 2; i++) {
            int firstIndex = i;
            int lastIndex = s.length() - 1 - i;
             arr.add(s.charAt(firstIndex));
             arr.add(s.charAt(lastIndex));
        }
        while (!arr.isEmpty()) {
            if (arr.pollFirst() == arr.poll()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}