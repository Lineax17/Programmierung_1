package indianajones.gamepieces;

public class Exit extends GamePiece{
    Exit(char letter, int lines, int columns) {
        super(lines, columns, 'E', lines/2, columns-1);
    }
}
