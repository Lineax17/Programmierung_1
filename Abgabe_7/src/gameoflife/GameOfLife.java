package gameoflife;

public class GameOfLife {
    // Configuration of game
    private static final int LINES = 72;
    private static final int COLUMNS = 167;
    private static final double PROBABILITY_TO_LIVE = 0.4;
    private static final int GENERATIONS = 10_000;
    private static final boolean USE_GAMEVIEW = true;

    public static void main(String[] args) {
        new GameOfLife().startGame();
    }


    private PetriDish petriDish;
    private Printer printer;

    private GameOfLife() {
        // Erzeugen Sie die beiden Instanzvariablen
        petriDish = new PetriDish(LINES, COLUMNS, PROBABILITY_TO_LIVE);
        printer = new Printer(petriDish, USE_GAMEVIEW);
    }

    private void startGame() {
        // Geben Sie die Start-Generation aus.
        // Laufen Sie in einer for-Schleife durch die Generationen 2 bis
        // GENERATIONS und geben Sie die jeweilige Generation aus.
        printer.printPetriDish();

        for (int i = 2; i <= GENERATIONS; i++) {
            petriDish.nextGeneration();
            printer.printPetriDish();
        }
    }
}

