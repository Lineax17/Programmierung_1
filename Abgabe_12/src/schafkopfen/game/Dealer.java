package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;

import java.util.Random;

public class Dealer {
    Animations animations;
    Card[] deck;

    Dealer() {
        animations = new Animations();
        deck = Card.createFreshDeckWith32Cards();
    }

    void play() {
        animations.showCardDeckStraight(deck);
        sleep(2000);
        animations.showShuffleAnimation();
        shuffle(System.currentTimeMillis());
        animations.showCardDeckCurved(deck);
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.play();
    }

    void shuffle(long seed) {
        Random random = new Random(seed);
        int bound = 32;
        int randomNumber;
        Card temp;
        for (int i = 0; i <= deck.length; i++) {
            randomNumber = random.nextInt(bound);
            temp = deck[i];
            deck[i] = deck[randomNumber];
            deck[randomNumber] = temp;
        }
    }

    void sleep(int milliseconds) {
        sleep(milliseconds);
    }
}
