import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p13_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String inputSequence = reader.readLine();
        char[] symbolSequence = inputSequence.toCharArray();
        if (areParenthesisBalanced(symbolSequence)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean areParenthesisBalanced(char[] symbols) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == '(' || symbols[i] == '[' || symbols[i] == '{') {
                stack.push(symbols[i]);
            }
            if (symbols[i] == ')' || symbols[i] == ']' || symbols[i] == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                } else if (!isMatchingPairs(stack.pop(), symbols[i])) {
                    return false;
                }
            }
        }
        return isBalanced;
    }

    private static boolean isMatchingPairs(Character character1, char character2) {
        if (character1 == '(' && character2 == ')') return true;
        else if (character1 == '[' && character2 == ']') return  true;
        else if (character1 == '{' && character2 == '}') return true;
        else return false;
    }
}