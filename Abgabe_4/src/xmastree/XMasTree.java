package xmastree;

public class XMasTree {
    public static void main(String[] args) {
        int height = 5;

        //Spitze

        for (int i = 2; i <= height; i++) {
            System.out.print(" ");
        }
        System.out.println("+");

        //Körper

        for (int line = 1; line <= height; line++) {
            for (int j = 1; j <= height - line; j++) {
                System.out.print(" ");
            }

            int numberOfStars = line * 2 - 1;
            for (int y = 1; y <= numberOfStars; y++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Stamm

        for (int i = 2; i <= height; i++) {
            System.out.print(" ");
        }
        System.out.println("U");
    }
}
