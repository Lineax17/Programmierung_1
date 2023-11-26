package indianajones.game;

import indianajones.gamepieces.*;

class GameElements extends GameField {
    Jones jones;
    Exit exit;
    Grail grail;
    Snake[] snakes;
    GamePiece[] allGamePieces;

    GameElements(int lines, int columns, int numberOfSnakes) {
        super(lines, columns, numberOfSnakes);
        jones = new Jones(lines, columns);
        exit = new Exit(lines, columns);
        grail = new Grail(lines, columns);
        snakes = new Snake[numberOfSnakes];
        allGamePieces = new GamePiece[3 + numberOfSnakes];

        //Snake Array füllen
        for (int i = 0; i < numberOfSnakes; i++) {
            snakes[i] = new Snake(lines, columns, jones);
        }

        //GamePieces füllen
        allGamePieces[0] = jones;
        allGamePieces[1] = grail;
        allGamePieces[2] = exit;

        for (int i = 3; i < allGamePieces.length; i++) {
            allGamePieces[i] = snakes[(allGamePieces.length - 1) - i];
        }

    }

    @Override
    char charAtPosition(int line, int column) {
        for (GamePiece gamePiece : allGamePieces) {
            if (gamePiece.getLine() == line && gamePiece.getColumn() == column) {
                return gamePiece.getLetter();
            }
        }
        return super.charAtPosition(line, column);
    }
}
