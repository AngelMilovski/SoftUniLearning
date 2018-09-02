package p11_card_game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int winner(Player otherPlayer) {
        return (this.getStrongestHand().compareTo(otherPlayer.getStrongestHand()));
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getStrongestHand() {
        return this.cards.stream().max(Card::compareTo).get();
    }

    public int getHands() {
        return this.cards.size();
    }
}
