package indianajones.gamepieces;

public class Exit extends GamePiece {
    public Exit(int lines, int columns) {
        super(lines, columns);
        letter = 'E';
        line = lines / 2;
        column = columns - 1;
    }
}
