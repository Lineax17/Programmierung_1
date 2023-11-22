package halloween;

public class Halloween {
    public static void main(String[] args) {
        Creature[] creatures = new Creature[3];

        creatures[0] = new Vampire("Dracula");
        creatures[1] = new Vampire("Nosferatu");
        creatures[2] = new Ghost("Caspar");

        for (Creature creature : creatures) {
            System.out.println(creature.jumpScare());

            if (creature instanceof Vampire) {
                Vampire vampire = (Vampire) creature;
                System.out.println(vampire.bite());
            } else if (creature instanceof Ghost ghost) {
                System.out.println(ghost.flyAway());
            }
        }
    }
}
