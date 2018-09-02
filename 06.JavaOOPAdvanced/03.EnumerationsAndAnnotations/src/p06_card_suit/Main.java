package p06_card_suit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Deck Suits:");
        Card[] cards = Card.values();
        Arrays.stream(cards).forEach(System.out::println);
    }
}
