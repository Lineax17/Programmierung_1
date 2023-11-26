package indianajones.gamepieces;

public class Grail extends GamePiece {

    public Grail(int lines, int columns) {
        super(lines, columns);
        letter = 'G';
        line = (int) (Math.random() * lines);
        column = (int) (Math.random() * columns);
    }

    public void beInvisible() {
        letter = (' ');
    }

}