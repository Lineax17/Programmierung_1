package indianajones.game;

import indianajones.gamepieces.GamePiece;

public class Game extends GameElements {
    public Game(int lines, int columns, int numberOfSnakes) {
        super(lines, columns, numberOfSnakes);
    }

    void nextIteration() {
        moveAllGamePieces();
    }

    void moveAllGamePieces() {
        for (GamePiece gamePiece : allGamePieces) {
            gamePiece.move();
        }

    }
}
