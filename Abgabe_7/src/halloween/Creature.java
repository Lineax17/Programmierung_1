package halloween;

class Creature {
    private String name;
    private String color;

    Creature(String name, String color) {
        this.name = name;
        this.color = color;
    }

    protected String jumpScare() {
        return name + ", " + color + ": ";
    }
}
