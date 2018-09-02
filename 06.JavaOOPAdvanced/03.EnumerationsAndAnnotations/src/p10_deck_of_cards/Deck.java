package p10_deck_of_cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deck;

    public Deck(String cardDeck) {

        this.deck = new ArrayList<>();

        fillDeck();
    }

    private void fillDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.deck.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getDeck() {
        return this.deck;
    }
}
