package p08_cards_with_power;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {

    private Rank rank;

    private Suit suit;

    private List<Card> deck;

    public Card(String rank, String suit) {
        this.rank = Rank.valueOf(rank.toUpperCase());
        this.suit = Suit.valueOf(suit.toUpperCase());
        this.deck = new ArrayList<>();
    }

    public int getPower() {
        return this.rank.getRankPower() + this.suit.getSuitPower();
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getPower(), other.getPower());
    }

    @Override
    public String toString() {
        return String.format("Deck name: %s of %s;",
                this.rank.name(),
                this.suit.name());
    }
}
