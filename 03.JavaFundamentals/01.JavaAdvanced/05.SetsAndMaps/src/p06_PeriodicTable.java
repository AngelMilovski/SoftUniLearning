import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class p06_PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCompounds = Integer.parseInt(reader.readLine());
        Set<String> chemicalElements = new TreeSet<>();
        fillElements(reader, numberOfCompounds, chemicalElements);
        StringBuilder sb = new StringBuilder();
        for (String chemicalElement : chemicalElements) {
            sb.append(chemicalElement).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void fillElements(BufferedReader reader, int numberOfCompounds, Set<String> chemicalElements) throws IOException {
        for (int i = 0; i < numberOfCompounds; i++) {
            String[] elements = reader.readLine().split(" ");
            chemicalElements.addAll(Arrays.asList(elements));
        }
    }
}