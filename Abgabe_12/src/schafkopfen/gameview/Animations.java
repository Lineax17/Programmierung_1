package schafkopfen.gameview;

import java.awt.*;
import java.util.Arrays;

/**
 * Diese Klasse ermöglicht es kleine Animationen eines bayerischen Kartenspiels anzuzeigen.
 */
public class Animations {
    private final GameView gameView;
    private final int cardHeight;
    private final int cardWidth;
    private final Card[][] playersCards;
    private final String[] playersNames;

    /**
     * Erzeugt eine Instanz dieser Klasse um Animationen anzeigen zu können.
     */
    public Animations() {
        this.gameView = new GameView();
        gameView.setBackgroundColor(Color.GREEN.darker().darker());
        gameView.setWindowIcon("eichel.png");
        gameView.setWindowTitle("Schafkopfen");
        cardHeight = 200;
        cardWidth = cardHeight * 60 / 90;
        playersNames = new String[4];
        playersCards = new Card[4][8];
    }

    /**
     * Zeigt das übergebene Kartenspiel an. Die Karten werden nebeneinander und untereinander angezeigt.
     *
     * @param deck Das anzuzeigende Kartenspiel.
     */
    public void showCardDeckStraight(Card[] deck) {
        Card[] one = Arrays.copyOfRange(deck, 0, 8);
        Card[] two = Arrays.copyOfRange(deck, 8, 16);
        Card[] three = Arrays.copyOfRange(deck, 16, 24);
        Card[] four = Arrays.copyOfRange(deck, 24, 32);
        int x = 35;
        int y = 35;
        gameView.playSound("deck.wav", false);
        for (int cards = 0; cards < deck.length; cards++) {
            addColor(x, y, one, cards);
            addColor(GameView.WIDTH / 2 + x, y, two, cards - 8);
            addColor(x, GameView.HEIGHT / 2 + y, three, cards - 16);
            addColor(GameView.WIDTH / 2 + x, GameView.HEIGHT / 2 + y, four, cards - 24);
            gameView.printCanvas();
            sleep(20);
        }
    }

    private void addColor(int x, int y, Card[] color, int upTo) {
        for (int i = 0; i <= Math.min(upTo, color.length - 1); i++) {
            Card card = color[i];
            addCardToCanvas(card, x, y - i * 2);
            x += 40;
        }
    }

    /**
     * Zeigt das übergebene Kartenspiel an. Die Karten werden in einem großen Bogen angezeigt.
     *
     * @param deck Das anzuzeigende Kartenspiel.
     */
    public void showCardDeckCurved(Card[] deck) {
        gameView.playSound("deck.wav", false);
        for (int p = 0; p < deck.length; p++) {
            int x = 8;
            int y = 8;
            for (int i = 0; i <= p; i++) {
                addCardToCanvas(deck[i], x, y);
                x += 26;
                y += i / 1.4;
            }
            gameView.printCanvas();
            sleep(20);
        }
    }

    /**
     * Zeigt eine kurze Animation in der Karten gemischt werden.
     */
    public void showShuffleAnimation() {
        gameView.playSound("shuffle.wav", false);
        for (int p = 0; p < 25; p++) {
            int rand = 3;
            int x = 380 + (int) (Math.random() * rand);
            int y = 150 + (int) (Math.random() * rand);
            for (int i = 0; i < 32; i++) {
                gameView.addImageToCanvas("card.png", x, y, 0.33, 45 + (int) (Math.random() * rand));
                x += Math.random() * rand;
                y += i / 10;
            }
            gameView.printCanvas();
            sleep(40);
        }
    }

    private boolean shuffled(Card[] deck) {
        String set = "AKOU10987";
        String order = set + set + set + set;
        StringBuilder cards = new StringBuilder();
        for (Card card : deck) {
            cards.append(card.rank);
        }
        return !cards.toString().equals(order);
    }

    /**
     * Zeigt die Karten eines Spielers an.
     *
     * @param playerNumber Die Nummer des Spielers: 1, 2, 3 oder 4.
     * @param name         Der Name des Spielers.
     * @param hand         Die Karten des Spielers.
     */
    public void showPlayersHand(int playerNumber, String name, Card[] hand) {
        gameView.playSound("shuffle.wav", false);
        playersNames[playerNumber - 1] = name;
        playersCards[playerNumber - 1] = hand;
        int xLeft = 100;
        int xRight = 520;
        int yTop = 30;
        int yBottom = 280;
        showPlayersHand(xLeft, yTop, 1);
        showPlayersHand(xRight, yTop, 2);
        showPlayersHand(xLeft, yBottom, 3);
        showPlayersHand(xRight, yBottom, 4);
        gameView.printCanvas();
        sleep(200);
        gameView.stopAllSounds();
    }

    private void showPlayersHand(int x, int y, int playerNumber) {
        if (playersNames[playerNumber - 1] != null) {
            gameView.addTextToCanvas(playersNames[playerNumber - 1], x, y - 20, 18, Color.WHITE, 0);
            int t = 0;
            for (int i = playersCards[playerNumber - 1].length - 1; i >= 0; i--) {
                if (playersCards[playerNumber - 1][i] != null) {
                    if (i == 0) {
                        addCardToCanvas(playersCards[playerNumber - 1][i], x + 7 * 30, y + 50);
                    } else if (i == 1) {
                        addCardToCanvas(playersCards[playerNumber - 1][i], x + 7 * 30, y + 43);
                    } else {
                        addCardToCanvas(playersCards[playerNumber - 1][i], x + 7 * 30, y + 35);
                    }
                    x -= 30;
                    y -= (i * 1.3 + 2) / 1.5;
                }
            }
        }
    }

    private void addCardToCanvas(Card card, int x, int y) {
        String color = card.color.toLowerCase();
        String rank = card.rank;
        // Backgound
        gameView.addRectangleToCanvas(x, y, cardWidth, cardHeight, 2, true, Color.WHITE);
        gameView.addRectangleToCanvas(x, y, cardWidth, cardHeight, 2, false, Color.BLACK);
        // Inner rectangle
        int lineWeight = 1;
        int fontSize = cardHeight * 15 / cardWidth;
        int gap = (int) (1.7 * fontSize);
        gameView.addLineToCanvas(x + fontSize, y + cardHeight / 2d, x + cardWidth - fontSize, y + cardHeight / 2d, lineWeight, Color.BLACK);
        gameView.addLineToCanvas(x + gap, y + fontSize / 2d, x + cardWidth - gap, y + fontSize / 2d, lineWeight, Color.BLACK);
        gameView.addLineToCanvas(x + gap, y + cardHeight - fontSize / 2d, x + cardWidth - gap, y + cardHeight - fontSize / 2d, lineWeight,
                                 Color.BLACK);
        gameView.addLineToCanvas(x + fontSize / 2d, y + gap * 1.2, x + fontSize / 2d, y + cardHeight - gap * 1.2, lineWeight, Color.BLACK);
        gameView.addLineToCanvas(x + cardWidth - fontSize / 2d, y + gap * 1.2, x + cardWidth - fontSize / 2d, y + cardHeight - gap * 1.2, lineWeight,
                                 Color.BLACK);
        // Ranks
        int xRightForTen = x + fontSize / 2;
        int xRight = x + fontSize / 5;
        int yUp = y + lineWeight;
        if (rank.equals("10")) {
            gameView.addTextToCanvas("1", x, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas("1", x + cardWidth - fontSize - fontSize / 2d, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas("0", x, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
            gameView.addTextToCanvas("0", x + cardWidth - fontSize - fontSize / 2d, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
            gameView.addTextToCanvas("0", xRightForTen, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas("0", x + cardWidth - fontSize, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas("1", xRightForTen, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
            gameView.addTextToCanvas("1", x + cardWidth - fontSize, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
        } else {
            gameView.addTextToCanvas(rank, xRight, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas(rank, x + cardWidth - fontSize, yUp, fontSize, Color.BLACK, 0);
            gameView.addTextToCanvas(rank, xRight, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
            gameView.addTextToCanvas(rank, x + cardWidth - fontSize, y + cardHeight - fontSize, fontSize, Color.BLACK, 180);
        }
        // Small colors
        double scaleFactorOfSmallColors = color.equals("eichel") ? fontSize / 70d : fontSize / 115d;
        xRight = x + fontSize / 3;
        gameView.addImageToCanvas(color + ".png", xRight, y + fontSize * 1.2, scaleFactorOfSmallColors, 0);
        gameView.addImageToCanvas(color + ".png", xRight + cardWidth - fontSize, y + fontSize * 1.2, scaleFactorOfSmallColors, 0);
        gameView.addImageToCanvas(color + ".png", xRight, y + cardHeight - (int) (1.5 * fontSize * 1.2), scaleFactorOfSmallColors, 180);
        gameView.addImageToCanvas(color + ".png", xRight + cardWidth - fontSize, y + cardHeight - (int) (1.5 * fontSize * 1.2),
                                  scaleFactorOfSmallColors,
                                  180);
        // Big colors
        double scaleFactorOfBigColors = scaleFactorOfSmallColors * 4;
        double eichelGap = color.equals("eichel") ? cardWidth / 15d : 0;
        gameView.addImageToCanvas(color + ".png", x + eichelGap + (cardWidth / 3d), y + 1.5 * fontSize, scaleFactorOfBigColors, 0);
        gameView.addImageToCanvas(color + ".png", x + eichelGap + (cardWidth / 3d), y + cardHeight / 2d + fontSize, scaleFactorOfBigColors, 180);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
