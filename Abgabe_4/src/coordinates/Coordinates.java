package coordinates;

public class Coordinates {
    public static void main(String[] args) {
        int highestX = 6;
        int highestY = 5;

        for (int i = 1; i <= highestX; i++) {
            for (int j = 1; j <= highestY; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }
}
