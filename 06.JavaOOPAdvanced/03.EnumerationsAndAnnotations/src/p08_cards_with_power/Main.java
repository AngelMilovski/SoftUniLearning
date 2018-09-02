package p08_cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String rankType = reader.readLine().toUpperCase();
        String suitType = reader.readLine().toUpperCase();

        try {
            Card card = new Card(rankType, suitType);
            System.out.println(String.format("Deck name: %s; Deck power: %d",
                    card,
                    card.getPower()));

        } catch (IllegalArgumentException ignored) {
            ;
        }
    }
}
