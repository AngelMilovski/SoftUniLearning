import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p12_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("JOKER".equals(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split(":\\s");
            String name = tokens[0];
            String[] cardTokens = tokens[1].split(",\\s");

            Set<String> cards = new HashSet<>();

            Collections.addAll(cards, cardTokens);

            if (players.containsKey(name)) {
                Set<String> previousCards = players.get(name);
                previousCards.addAll(cards);
            } else {
                players.put(name, cards);
            }
        }

        Map<String, Integer> types = new HashMap<>();
        types.put("S", 4);
        types.put("H", 3);
        types.put("D", 2);
        types.put("C", 1);

        Map<String, Integer> powers = new HashMap<>();
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            int totalCardsStrength = 0;
            for (String card : player.getValue()) {
                String power = card.substring(0, card.length() - 1);
                String type = String.valueOf(card.charAt(card.length() - 1));
                totalCardsStrength += computeCardStrength(power, type, types, powers);
            }
            System.out.printf("%s: %d%n", player.getKey(), totalCardsStrength);
        }
    }

    private static int computeCardStrength(String power, String type, Map<String, Integer> types, Map<String, Integer> powers) {
        int resultPower;
        try {
            resultPower = Integer.parseInt(power);
        } catch (NumberFormatException nfe) {
            resultPower = powers.get(power);
        }
        return types.get(type) * resultPower;
    }
}