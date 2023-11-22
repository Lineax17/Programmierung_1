package games.dice;

public class Dice {
    private String color;
    private int pips;

    public Dice(String color) {
        pips = -1;
        this.color = color;
    }

    public void roll() {
        pips = 1 + (int) (Math.random() * 6);
    }

    public int getPips() {
        return pips;
    }

    public String getColor() {
        return color;
    }
}



