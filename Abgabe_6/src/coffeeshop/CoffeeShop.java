package coffeeshop;

public class CoffeeShop {
    public static void main(String[] args) {
        Cake applePie = new Cake("Apfelkuchen", 12, 2.80);
        Cake cheeseCake = new Cake("Käsekuchen", 8, 3.20);

        if (applePie.hasPieces()) {
            applePie.takePiece();
        }
        applePie.print();


        if (cheeseCake.hasPieces()) {
            cheeseCake.takePiece();
        }
        cheeseCake.print();

    }
}
