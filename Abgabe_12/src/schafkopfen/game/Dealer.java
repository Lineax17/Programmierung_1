package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;

import java.util.Random;

import static java.util.Arrays.copyOfRange;

public class Dealer {
    private Animations animations;
    Card[] deck;
    Player[] players;

    Dealer() {
        animations = new Animations();
        deck = Card.createFreshDeckWith32Cards();
        players = new Player[4];
    }

    void play() throws IllegalCardDeckException {
        animations.showCardDeckStraight(deck);
        sleep(2000);
        animations.showShuffleAnimation();
        shuffle(System.currentTimeMillis());
        animations.showCardDeckCurved(deck);
        sleep(2000);
        dealCards();
    }

    public static void main(String[] args) throws IllegalCardDeckException {
        Dealer dealer = new Dealer();
        dealer.play();
    }

    void shuffle(long seed) {
        Random random = new Random(seed);
        int bound = 32;
        int randomNumber;
        Card temp;
        for (int i = 0; i < deck.length; i++) {
            randomNumber = random.nextInt(bound);
            temp = deck[i];
            deck[i] = deck[randomNumber];
            deck[randomNumber] = temp;
        }
    }

    void sleep(int milliseconds) {
        sleep(milliseconds);
    }

    void checkCardDeckValidity() throws IllegalCardDeckException {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) {
                throw new IllegalCardDeckException("Card is null at: " + i);
            }
            for (int j = 0; j < deck.length; j++) {
                if (i != j && deck[i].equals(deck[j])) {
                    throw new IllegalCardDeckException("Cards are equal: " + i + "; " + j);
                }
            }
        }
    }

    void dealCards() throws IllegalCardDeckException {
        checkCardDeckValidity();
        players[0].setHand(copyOfRange(deck, 0, 8));
        players[1].setHand(copyOfRange(deck, 8, 16));
        players[2].setHand(copyOfRange(deck, 16, 24));
        players[3].setHand(copyOfRange(deck, 24, 32));
        sleep(1000);
        for (int i = 0; i <= players.length; i++) {
            players[i].sortCards();
        }


    }
}
