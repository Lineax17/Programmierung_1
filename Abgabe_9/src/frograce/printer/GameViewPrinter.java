package frograce.printer;

import frograce.game.Game;

public class GameViewPrinter {

    private int trackDistanceInCm;
    private Game game;

    public GameViewPrinter(Game game, int trackDistanceInCm) {
        this.game = game;
        this.trackDistanceInCm = trackDistanceInCm;
        GameView.showGameView(true);
    }

    public void printAndSleep(int sleepTimeInMilliseconds) {
        int minFontSize = 5;
        int maximumFontSize = 30;
        int desiredFontSize = 15_000 / (trackDistanceInCm + 30);
        int fontSize = Math.max(minFontSize, Math.min(maximumFontSize, desiredFontSize));
        GameView.print(game.toString(), fontSize, true, 0.9);
        GameView.sleep(sleepTimeInMilliseconds);
    }
}
