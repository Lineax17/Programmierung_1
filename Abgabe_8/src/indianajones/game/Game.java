package indianajones.game;

import indianajones.gamepieces.GamePiece;

public class Game extends GameElements {
    private boolean gameOver;
    private boolean jonesWonTheGame;

    public Game(int lines, int columns, int numberOfSnakes) {
        super(lines, columns, numberOfSnakes);
    }

    public void nextIteration() {
        if (!gameOver) {
            moveAllGamePieces();
            updateGameLogic();
        }
    }

    private void moveAllGamePieces() {
        for (GamePiece gamePiece : allGamePieces) {
            gamePiece.move();
        }
    }

    private void updateGameLogic() {
        for (int i = 0; i < snakes.length; i++) {
            if (jones.hasSamePositionAs(snakes[i])) {
                gameOver = true;
                jonesWonTheGame = false;
            }
        }
        if (jones.hasSamePositionAs(grail)) {
            jones.setGrail(true);
            grail.beInvisible();
        }
        if (jones.hasGrail() && jones.hasSamePositionAs(exit)) {
            gameOver = true;
            jonesWonTheGame = true;
        }

    }

    @Override
    char charAtPosition(int line, int column) {
        if (gameOver) {
            if (jonesWonTheGame) {
                return 'J';
            } else {
                return 'S';
            }
        } else {
            return super.charAtPosition(line, column);
        }
    }
}
