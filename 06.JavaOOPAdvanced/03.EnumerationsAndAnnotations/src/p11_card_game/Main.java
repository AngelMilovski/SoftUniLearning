package p11_card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);
        Deck deck = new Deck();

        String debug = "";
        while (true) {
            if (firstPlayer.getHands() == 5 && secondPlayer.getHands() == 5) {
                break;
            }
            String[] cardType = reader.readLine().split(" of ");
            try {
                Rank rank = Rank.valueOf(cardType[0]);
                Suit suit = Suit.valueOf(cardType[1]);
                Card card = new Card(rank, suit);

                if (deck.containsCard(card)) {

                    if (firstPlayer.getHands() < 5) {
                        firstPlayer.addCard(card);
                    } else {
                        secondPlayer.addCard(card);
                    }

                    deck.removeCard(card);
                } else {
                    System.out.println("Card is not in the deck.");
                    continue;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("No such card exists.");
                continue;
            }
        }

        Player winner = firstPlayer.winner(secondPlayer) > 0 ?
                firstPlayer : secondPlayer;

        System.out.println(String.format("%s wins with %s.", winner.getName(), winner.getStrongestHand()));

    }
}
