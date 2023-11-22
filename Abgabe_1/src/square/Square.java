package square;

public class Square {
    public static void main(String[] args) {
        double length;
        length = 20.0;

        double area = length * length;
        double diagonal = length * Math.sqrt(2);

        System.out.println("Seitenlänge des Quadrats: " + length);
        System.out.println("Fläche des Quadrats: " + area);
        System.out.println("Länge der Diagonale des Quadrats: " + diagonal);
    }
}
