package schafkopfen.game;

import schafkopfen.gameview.Animations;
import schafkopfen.gameview.Card;
import schafkopfen.game.CardSorter;

public class Player {
    private Animations animations;
    private String name;
    private int playerNumber;
    private Card[] hand;

    Player(Animations animations, String name, int playerNumber) {
        this.animations = animations;
        this.name = name;
        this.playerNumber = playerNumber;
    }

    void setHand(Card[] hand) {
        this.hand = hand;
        animations.showCardDeckCurved(hand);
    }

    void sortCards() {
        CardSorter cardSorter = new CardSorter(hand);
        cardSorter.selectionSort();
        animations.showCardDeckCurved(hand);
    }
}
