package halloween;

class Ghost extends Creature {
    Ghost(String name) {
        super(name, "weiß");
    }

    @Override
    protected String jumpScare() {
        return super.jumpScare() + "BUUUH!";
    }

    String flyAway() {
        return "-> Fliegt weg.";
    }
}
