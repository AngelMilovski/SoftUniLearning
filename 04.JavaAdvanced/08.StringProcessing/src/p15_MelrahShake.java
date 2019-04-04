import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder copySymbols = new StringBuilder();
        StringBuilder patt = new StringBuilder();
        String symbols = reader.readLine();
        copySymbols.append(symbols);
        String pattern = reader.readLine();
        patt.append(pattern);
        while (true) {
            if (pattern.equals("")) {
                System.out.println("No shake.");
                break;
            }
            if (symbols.equals("")) {
                break;
            }
            if (symbols.contains(pattern)) {
                pattern = patt.toString();
                int patternLength = pattern.length();

                int firstIndex = copySymbols.indexOf(pattern);
                if (firstIndex != -1) {
                    for (int i = firstIndex; i < (firstIndex + patternLength); i++) {
                        copySymbols.deleteCharAt(firstIndex);
                    }
                }
                int lastIndex = copySymbols.lastIndexOf(pattern);
                if (lastIndex != -1) {
                    for (int i = lastIndex; i < (lastIndex + patternLength); i++) {
                        copySymbols.deleteCharAt(lastIndex);
                    }
                }

                if (firstIndex != -1 && lastIndex != -1) {
                    System.out.println("Shaked it.");
                } else {
                    System.out.println("No shake.");
                }
            } else {
                System.out.println("No shake.");
                break;
            }
            patt.deleteCharAt(pattern.length() / 2);
            pattern = patt.toString();
            symbols = copySymbols.toString();

        }
        System.out.println(symbols);
    }
}