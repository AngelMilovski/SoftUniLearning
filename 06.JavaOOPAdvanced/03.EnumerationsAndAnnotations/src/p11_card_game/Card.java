package p11_card_game;

public class Card implements Comparable<Card> {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getRankPower() + this.suit.getSuitPower();
    }


    @Override
    public int compareTo(Card other) {
        int compareByRank = Integer.compare(this.getPower(), other.getPower());

        if (compareByRank != 0) {
            return compareByRank;
        } else {
            return this.suit.compareTo(other.suit);
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank.name(), this.suit.name());
    }
}
