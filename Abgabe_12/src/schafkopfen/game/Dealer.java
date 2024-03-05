package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;

import java.util.Random;

public class Dealer {
    private Animations animations;
    Card[] deck;
    Player[] players = new Player[4];

    Dealer() {
        animations = new Animations();
        deck = Card.createFreshDeckWith32Cards();

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
    }
}
