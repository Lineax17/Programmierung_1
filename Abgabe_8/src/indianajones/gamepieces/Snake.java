package indianajones.gamepieces;

public class Snake extends GamePiece {
    Jones jones;

    public Snake(int lines, int columns, Jones jones) {
        super(lines, columns);
        letter = 'S';
        line = (int) (Math.random() * lines);
        column = columns - 1;
        this.jones = jones;
    }

    @Override
    public void move() {
        boolean moveVertical = Math.random() < 0.5f;

        if ((moveVertical && line != jones.getLine())) {
            if (line > jones.getLine()) {
                line = line - 1;
            } else {
                line = line + 1;
            }

        } else if ((!moveVertical && column != jones.getColumn())) {
            if (column > jones.getColumn()) {
                column = column - 1;
            } else {
                column = column + 1;
            }
        }

    }
}
