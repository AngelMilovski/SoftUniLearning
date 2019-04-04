import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class p05_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] input = reader.readLine().split(" ");
        int firstSetLength = Integer.valueOf(input[0]);
        int secondSetLength = Integer.valueOf(input[1]);
        Set<String> firstSet = new LinkedHashSet<>(firstSetLength);
        Set<String> secondSet = new LinkedHashSet<>(secondSetLength);
        fillSets(reader, firstSetLength, firstSet);
        fillSets(reader, secondSetLength, secondSet);
        StringBuilder sb = new StringBuilder();
        for (String element : firstSet) {
            if (secondSet.contains(element)) {
                sb.append(element + " ");
            }
        }
        if (!"".equals(sb.toString())); {
            System.out.println(sb.toString().trim());
        }
    }

    private static void fillSets(BufferedReader reader, int length, Set<String> set) throws IOException {
        for (int i = 0; i < length; i++) {
             set.add(reader.readLine());
        }
    }
}
