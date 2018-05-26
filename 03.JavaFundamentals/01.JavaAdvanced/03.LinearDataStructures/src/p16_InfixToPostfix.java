import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p16_InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }
        String infix = sb.toString();
        System.out.println(infixToPostfix(infix));
    }

    private static String infixToPostfix(String infix) {

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> operator = new ArrayDeque<>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get))
                sb.append(get + " ");

            else if (get == ')')
                while ((popped = operator.pop()) != '(')
                    sb.append(popped + " ");

            else {
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
                    sb.append(operator.pop() + " ");

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            sb.append(operator.pop() + " ");

        return sb.toString();
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }
}
