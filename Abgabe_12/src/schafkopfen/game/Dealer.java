package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;

public class Dealer {
    Animations animations;
    Card[] deck;

    Dealer() {
        animations = new Animations();
        deck = Card.createFreshDeckWith32Cards();
    }

    void play() {
        animations.showCardDeckStraight(deck);

    }
}
