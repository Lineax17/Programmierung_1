package indianajones.gamepieces;

public class Grail extends GamePiece {

    Grail(int lines, int columns, char letter) {
        super(lines, columns, 'G', (int)(Math.random() * lines), (int)(Math.random() * columns));
    }
}