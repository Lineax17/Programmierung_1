package ships;

import java.util.Objects;

class Ship implements Cloneable {
    private final String name;
    private final int yearOfConstruction;
    private String color;

    Ship(String name, String color, int yearOfConstruction) {
        this.name = name;
        this.color = color;
        this.yearOfConstruction = yearOfConstruction;
    }

    void setColor(String color) {
        this.color = color;
    }

    @Override
    public Ship clone() {
        Ship other = null;
        try {
            other = (Ship) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ship ship = (Ship) o;
        return yearOfConstruction == ship.yearOfConstruction && Objects.equals(name, ship.name) && Objects.equals(color, ship.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, yearOfConstruction);
    }

    @Override
    public String toString() {
        return "[Name " + name + ", Farbe " + color + ", Baujahr " + yearOfConstruction + "]";
    }
}
