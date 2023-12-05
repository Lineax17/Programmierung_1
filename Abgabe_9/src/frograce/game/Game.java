package frograce.game;

public class Game {
    private Track track;
    private Frog[] frogs;
    private Frog winningFrog;
    private boolean gameOver;

    public Game(String trackName, int distanceInCm, Frog[] frogs) {
        gameOver = false;
        this.frogs = frogs;
        track = new Track(trackName, distanceInCm, frogs.clone());
    }

    public void nextIteration() {
        shuffleFrogs();
        letFrogsJumpAndCheckForWinner();
    }

    private void shuffleFrogs() {
        for (int i = 0; i < frogs.length; i++) {
            int randomFrogIndex = (int) (Math.random() * frogs.length);
            Frog temp;

            temp = frogs[i];
            frogs[i] = frogs[randomFrogIndex];
            frogs[randomFrogIndex] = temp;
        }
    }

    private void letFrogsJumpAndCheckForWinner() {
        for (Frog frog : frogs) {
            frog.jump();
            if (frog.getCurrentDistanceInCm() >= track.getDistanceInCm()) {
                winningFrog = frog;
                gameOver = true;
                break;
            }
        }
    }


    @Override
    public String toString() {
        if (gameOver) {
            return track.toString() + "\n\n\n" + winningFrog.getName() + " hat gewonnen!";
        } else {
            return track.toString();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}

