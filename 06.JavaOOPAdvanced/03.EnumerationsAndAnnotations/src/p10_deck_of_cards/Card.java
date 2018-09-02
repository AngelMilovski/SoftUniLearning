package p10_deck_of_cards;

public class Card {

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank.name(), this.suit.name());
    }
}
