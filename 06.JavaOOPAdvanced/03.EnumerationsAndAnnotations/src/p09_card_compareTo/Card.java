package p09_card_compareTo;



public class Card implements Comparable<Card> {
    private Rank rank;

    private Suit suit;

    public Card(String rank, String suit) {
        this.rank = Rank.valueOf(rank.toUpperCase());
        this.suit = Suit.valueOf(suit.toUpperCase());
    }

    public int getPower() {
        return this.rank.getRankPower() + this.suit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Deck name: %s of %s;",
                this.rank.name(),
                this.suit.name());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getPower(), other.getPower());
    }
}
