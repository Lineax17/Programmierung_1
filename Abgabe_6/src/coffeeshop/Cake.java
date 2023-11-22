package coffeeshop;

public class Cake {
    String name;
    int pieces;
    double pricePerPiece;

    Cake(String name, int pieces, double pricePerPiece) {
        this.name = name;
        this.pieces = pieces;
        this.pricePerPiece = pricePerPiece;
    }


    void takePiece() {
        if (hasPieces()) {
            pieces = pieces - 1;
        }
    }

    boolean hasPieces() {
        return pieces > 0;
    }

    double valueOfCake() {
        double price = 0.0;
        for (int i = 1; i <= pieces; i++) {
            price = price + pricePerPiece;
        }
        return Math.round(price * 10) / 10.0;
    }
    void print() {
        System.out.println(name + " mit " + pieces + " Stücken. Restwert: " + valueOfCake() + " Euro.");
    }
}
