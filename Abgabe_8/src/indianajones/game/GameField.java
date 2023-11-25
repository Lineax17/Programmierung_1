package indianajones.game;

public class GameField {
    int lines;
    int columns;
    int numberOfSnakes;

    GameField(int lines, int columns, int numberOfSnakes) {
        this.lines = lines;
        this.columns = columns;
        this.numberOfSnakes = numberOfSnakes;
    }

    @Override
    public String toString() {
        String table = "";
        for (int line = 0; line <= lines; line++) {
            for (int column = 0; column <= columns; column++) {
                table = table + charAtPosition(line, column);
            }
            table = table +"\n";
        }
        return table;
    }

    char charAtPosition(int line, int column) {
        return ' ';
    }
}
