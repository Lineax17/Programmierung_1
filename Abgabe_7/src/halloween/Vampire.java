package halloween;

class Vampire extends Creature {
    Vampire(String name) {
        super(name, "schwarz");
    }

    @Override
    protected String jumpScare() {
        return super.jumpScare() + "AAAAHHHH!";
    }

    String bite() {
        return "-> Beißt zu.";
    }
}
