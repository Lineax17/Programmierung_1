package ships;

class ShipYard {
    public static void main(String[] args) {
        new ShipYard().printProgress();
    }

    private void printProgress() {
        System.out.println("Die Titanic");
        Ship titanic = null;
        print("boatIsInitialized(titanic)", shipIsInitialized(titanic));
        print("Die Titanic", titanic);
        titanic = new Ship("Titanic", "rot", 1909);
        print("boatIsInitialized(titanic)", shipIsInitialized(titanic));

        System.out.println("\nEine zweite Referenz: unsinkable");
        Ship unsinkable = titanic;
        print("Unsinkable", unsinkable);
        print("exactlyTheSameBoat(titanic, unsinkable)", exactlyTheSameShip(titanic, unsinkable));
        print("similarBoat(titanic, unsinkable)", similarShip(titanic, unsinkable));

        System.out.println("\nEin Klon: titanicClone");
        Ship titanicClone = cloneShip(titanic);
        print("Titanic-Klon", titanicClone);
        print("exactlyTheSameBoat(titanic, titanicClone)", exactlyTheSameShip(titanic, titanicClone));
        print("similarBoat(titanic, titanic)", similarShip(titanic, titanic));

        System.out.println("\nDie Titanic wird umlackiert: gelb");
        changeColor(titanic, "gelb");
        print("Die Titanic", titanic);
        print("Unsinkable", unsinkable);
        print("Titanic-Klon", titanicClone);
    }

    private void print(String description, Ship ship) {
        System.out.print(description + ": ");
        printShip(ship);
    }

    private void print(String description, boolean content) {
        System.out.println(description + ": " + content);
    }

    /**
     * Stellt fest, ob ein Schiff bereits initialisiert wurde.
     *
     * @param ship Ein Schiff.
     * @return True, falls das Schiff schon initialisiert wurde, sonst false.
     */
    private boolean shipIsInitialized(Ship ship) {
        return ship != null;
    }

    /**
     * Gibt ein Schiff auf der Kommandozeile aus.
     *
     * @param ship Ein Schiff.
     */
    private void printShip(Ship ship) {
        if (shipIsInitialized(ship)) {
            System.out.println(ship);
        }
    }

    /**
     * Ein Schiff wird geklont.
     *
     * @param ship Das zu klonende Schiff.
     * @return Der Klon.
     */

    private Ship cloneShip(Ship ship) {
        return ship.clone();
    }

    /**
     * Stellt fest, ob es sich zweimal um exakt das gleiche Schiff handelt.
     *
     * @param one   Ein Schiff.
     * @param other Ein Schiff.
     * @return True, falls es sich exakt um das gleiche Schiff handelt, sonst False.
     */
    private boolean exactlyTheSameShip(Ship one, Ship other) {
       return one == other;
    }

    /**
     * Stellt fest, beide Schiffe die gleichen Eigenschaften haben.
     *
     * @param one   Ein Schiff.
     * @param other Ein Schiff.
     * @return True, falls beide Schiffe die gleichen Eigenschaften haben, sonst False.
     */
    private boolean similarShip(Ship one, Ship other) {
        return one.equals(other);
    }

    /**
     * Ein Schiff wird umlackiert.
     *
     * @param ship     Ein Schiff.
     * @param newColor Die neue Farbe des Schiffes.
     */
    private void changeColor(Ship ship, String newColor) {
        ship.setColor(newColor);
    }
}
