package indianajones.gamepieces;

class GamePiece {
    private int lines;
    private int columns;
    private int line;
    private int column;
    private char letter;

    GamePiece(int lines, int columns, char letter, int line, int column) {
        this.lines = lines;
        this.columns = columns;
    }

    void move() {

    }

    int getLine() {
        return line;
    }

    int getColumn() {
        return column;
    }

    char getLetter() {
        return letter;
    }
}
