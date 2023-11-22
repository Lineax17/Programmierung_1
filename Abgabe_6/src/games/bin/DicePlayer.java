package games.bin;

import games.dice.Dice;

public class DicePlayer {
    public static void main(String[] args) {
        Dice blueDice = new Dice("blau");
        Dice greenDice = new Dice("grün");

        for (int i = 1; i <= 3; i++) {
            greenDice.roll();
            blueDice.roll();
            System.out.println("Würfel " + blueDice.getColor() + ": " + blueDice.getPips());
            System.out.println("Würfel " + greenDice.getColor() + ": " + greenDice.getPips());
            System.out.println();
        }
    }
}
