package p09_card_compareTo;


import p09_card_compareTo.annotation.MyAnnotation;

@MyAnnotation(category = "Suit", description = "Provides suit constants for a Deck class")
public enum Suit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    Suit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }
}
