package p10_deck_of_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        Deck cards = new Deck(reader.readLine());
        cards.getDeck().forEach(System.out::println);
    }
}
