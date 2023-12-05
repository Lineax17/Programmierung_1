package frograce.game;

class Track {
    private String name;
    private int distanceInCm;
    private Frog[] frogs;

    Track(String name, int distanceInCm, Frog[] frogs) {
        this.name = name;
        this.distanceInCm = distanceInCm;
        this.frogs = frogs;
    }

    int getDistanceInCm() {
        return distanceInCm;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("\n").append(name).append(": ").append(distanceInCm).append(" Zentimeter").append("\n\n");
        createEdgeLine(display);
        display.append("\n\n\n");
        for (Frog frog : frogs) {
            display.append("        ").append(frog.toString()).append("\n\n");
        }
        createEdgeLine(display);
        return display.toString();
    }

    private void createEdgeLine(StringBuilder display) {
        display.append("\n").append(" ").append("Start ").append("|");
        for (int i = 1; i <= distanceInCm; i += 10) {
            display.append("-");
        }
        display.append("|").append(" ").append("Ziel");
    }
}
