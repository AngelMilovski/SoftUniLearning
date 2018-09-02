package p11_card_game;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deck;

    public Deck() {
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

    public boolean containsCard(Card card) {
        return this.deck.stream().anyMatch(card1 -> card1.compareTo(card) == 0);
    }

    public void removeCard(Card card) {
        this.deck.removeIf(card1 -> card1.compareTo(card) == 0);
    }
}
