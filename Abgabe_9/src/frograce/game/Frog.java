package frograce.game;

public class Frog {
    private static final int MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM = 100;
    private String name;
    private double strength;
    private double endurance;
    private double willpower;
    private int currentDistanceInCm;

    public Frog(String name, double strength, double endurance, double willpower) {
        this.name = name;
        this.strength = strength;
        this.endurance = endurance;
        this.willpower = willpower;
    }

    private int calculateMaximumJumpDistanceInCmForNextJump() {
        double calculatedDistance = strength * MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM - ((1 - endurance) * currentDistanceInCm / 2);
        return (int) Math.max(calculatedDistance, MAXIMUM_POSSIBLE_JUMP_DISTANCE_IN_CM / 4.0);
    }

    void jump() {
        if (Math.random() < willpower) {
            int lenght = (int) ((Math.random() * calculateMaximumJumpDistanceInCmForNextJump()));
            currentDistanceInCm = currentDistanceInCm + lenght;
        }
    }

    String getName() {
        return name;
    }

    int getCurrentDistanceInCm() {
        return currentDistanceInCm;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for (int i = 1; i <= currentDistanceInCm; i += 10) {
            display.append("=");
        }
        display.append("> ").append(name);
        return display.toString();
    }

}
