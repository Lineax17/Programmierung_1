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
}
