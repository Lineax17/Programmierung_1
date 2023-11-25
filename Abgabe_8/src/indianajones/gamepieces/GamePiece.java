package indianajones.gamepieces;

public class GamePiece {
    protected int lines;
    protected int columns;
    protected int line;
    protected int column;
    protected char letter;

    GamePiece(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
    }

    public void move() {

    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public char getLetter() {
        return letter;
    }

}
