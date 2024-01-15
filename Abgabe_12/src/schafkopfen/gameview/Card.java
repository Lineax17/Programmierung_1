package schafkopfen.gameview;

import java.util.Objects;

/**
 * Diese Klasse repräsentiert eine einzelne Karte aus einem bayerischen Kartenspiel.
 */
public class Card {

    /**
     * Die Farbe dieser Karte ("Eichel", "Gruen", "Herz", oder "Schelln").
     */
    public final String color;
    /**
     * Der Wert dieser Karte ("7", "8", "9", "10", "U", "O", "K", "A").
     */
    public final String rank;

    /**
     * Erzeugt ein bayerisches Kartenspiel mit 32 Karten.
     *
     * @return Das Kartenspiel als Array vom Typ Card.
     */
    public static Card[] createFreshDeckWith32Cards() {
        Card[] deck = new Card[32];
        int counter = 0;
        String[] cardColors = {"Schelln", "Herz", "Gruen", "Eichel"};
        String[] cardRanks = {"7", "8", "9", "10", "U", "O", "K", "A"};
        for (String color : cardColors) {
            for (String rank : cardRanks) {
                deck[counter++] = new Card(color, rank);
            }
        }
        return deck;
    }

    private Card(String color, String rank) {
        this.color = color;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(color, card.color) && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, rank);
    }

    @Override
    public String toString() {
        return color + " " + rank;
    }
}
