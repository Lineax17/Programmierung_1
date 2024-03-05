package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;

public class Player {
    Animations animations;
    String name;
    int playerNumber;
    Card[] hand;

    Player(Animations animations, String name, int playerNumber, Card[] hand) {
        this.animations = animations;
        this.name = name;
        this.playerNumber = playerNumber;
    }

    void setHand(Card[] hand) {
        this.hand = hand;
        animations.showCardDeckCurved(hand);
    }
}
