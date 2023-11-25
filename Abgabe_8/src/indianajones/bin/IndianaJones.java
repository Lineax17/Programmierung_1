
package indianajones.bin;


/*
import indianajones.game.Game;
import indianajones.game.GameView;

import java.awt.event.KeyEvent;

*/

import indianajones.game.Game;

public class IndianaJones {

    public static void main(String[] args) {
        Game game = new Game(10, 20, 3);
        System.out.println(game.toString());
    }
    /*
    private static final int LINES = 45;
    private static final int COLUMNS = 104;
    private static final int NUMBER_OF_SNAKES = 100;

    private Game game;

    public static void main(String[] args) {
        new IndianaJones().startGameLoop();
    }

    public IndianaJones() {
        GameView.showGameView(true);
        initializeGame();
    }

    private void initializeGame() {
        game = new Game(LINES, COLUMNS, NUMBER_OF_SNAKES);
        printToGameView();
        GameView.sleep(1000);
    }

    private void startGameLoop() {
        while (true) {
            game.nextIteration();
            printToGameView();
            checkForReplay();
            GameView.sleep(30);
        }
    }

    private void printToGameView() {
        GameView.print(game.toString(), 20, true, 0.8);
    }

    private void checkForReplay() {
        if (GameView.keyPressed(KeyEvent.VK_N)) {
            initializeGame();
        }
    }

    */
}
