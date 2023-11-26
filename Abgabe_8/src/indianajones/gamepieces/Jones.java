package indianajones.gamepieces;

import indianajones.game.GameView;

import static java.awt.event.KeyEvent.*;


public class Jones extends GamePiece {
    boolean grail;

    public Jones(int lines, int columns) {
        super(lines, columns);
        letter = 'J';
        line = lines / 2;
        column = 0;
    }

    boolean hasSamePositionAs(GamePiece gamePiece) {
        return super.getLine() == gamePiece.getLine() && super.getColumn() == gamePiece.getColumn();
    }

    @Override
    public void move() {
        if (GameView.keyPressed(VK_UP)) {
            line = line - 1;
        }
        if (GameView.keyPressed(VK_DOWN)) {
            line = line + 1;
        }
        if (GameView.keyPressed(VK_LEFT)) {
            column = column - 1;
        }
        if (GameView.keyPressed(VK_RIGHT)) {
            column = column + 1;
        }

    }
}
