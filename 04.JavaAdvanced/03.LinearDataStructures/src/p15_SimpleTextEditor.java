import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p15_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int numberOfCommands = Integer.parseInt(reader.readLine());
        ArrayDeque<String> lastStrings = new ArrayDeque<>();
        String currentStr = "";
        lastStrings.push(currentStr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = reader.readLine().split(" ");
            switch (commands[0]) {
                case "1":
                    currentStr += commands[1];
                    lastStrings.push(currentStr);
                    break;
                case "2":
                    int count = Integer.parseInt(commands[1]);
                    int endIndex = Math.abs(count - currentStr.length());
                    currentStr = currentStr.substring(0, endIndex);
                    lastStrings.push(currentStr);
                    break;
                case "3":
                    int indexForPrint = Integer.parseInt(commands[1]);
                    sb.append(currentStr.charAt(indexForPrint - 1))
                    .append(System.lineSeparator());
                    break;
                case "4":
                    lastStrings.poll();
                    currentStr = lastStrings.peek();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}