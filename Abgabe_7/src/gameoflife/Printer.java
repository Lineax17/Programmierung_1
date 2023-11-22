package gameoflife;

class Printer {
    private PetriDish petriDish;
    private boolean useGameView;

    Printer(PetriDish petriDish, boolean useGameView) {
        this.petriDish = petriDish;
        this.useGameView = useGameView;
        if (useGameView) {
            GameView.showGameView(true);
        }
    }

    void printPetriDish() {

        if (useGameView) {
            GameView.print(petriDish.asString(false), 6, true);
        } else {
            System.out.println(petriDish.asString(true));
        }
    }


}
