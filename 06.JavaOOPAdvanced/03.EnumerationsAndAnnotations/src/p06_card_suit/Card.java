package p06_card_suit;

import java.util.Arrays;

public enum Card {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.ordinal(), this.name());
    }


}
