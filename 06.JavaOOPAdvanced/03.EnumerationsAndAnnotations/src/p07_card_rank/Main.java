package p07_card_rank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Deck Ranks:");

        Card[] cards = Card.values();

        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
