package indianajones.gamepieces;

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


}
