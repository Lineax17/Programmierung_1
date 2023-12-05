package frograce.bin;

import frograce.game.Frog;
import frograce.game.Game;
import frograce.printer.GameViewPrinter;

public class FrogRace {
    private Game game;
    private GameViewPrinter gameViewPrinter;


    FrogRace() {
        Frog[] frogs = new Frog[4];
        frogs[0] = new Frog("Conan", 0.3, 2.0, 0.7);
        frogs[1] = new Frog("Hägar", 1.2, 0.3, 0.9);
        frogs[2] = new Frog("Laurin", 1.7, 1.7, 0.7);
        frogs[3] = new Frog("Tom", 0.4, 0.6, 0.5);
        String trackName = "Monte Carlo";
        int trackDistanceInCm = 600;

        game = new Game(trackName, trackDistanceInCm, frogs);
        gameViewPrinter = new GameViewPrinter(game, trackDistanceInCm);

        gameViewPrinter.printAndSleep(1000);
    }

    private void startGameLoop() {
        while (!game.isGameOver()) {
            game.nextIteration();
            gameViewPrinter.printAndSleep(300);
        }
    }


    public static void main(String[] args) {
        new FrogRace().startGameLoop();
    }
}

