package plateau;

public class Plateau {
    public static void main(String[] args) {
        int[] altitudes = {10, 17, 17, 17, 17, 17, 11, 10, 14, 10, 11, 11, 11, 9, 13, 15, 16, 16, 13};

        int heightOfPlateau;
        int lengthOfPlateau = 0;
        int startIndexOfPalteau = 0;
        boolean onPlateau = false;

        for (int i = 0; i < altitudes.length; i++) {
            if (i > 0 && i < altitudes.length - 1) {
                if (onPlateau) {
                    if (altitudes[i - 1] == altitudes[i] && altitudes[i] == altitudes[i + 1]) {
                        lengthOfPlateau++;
                    } else if (altitudes[i - 1] == altitudes[i] && altitudes[i] > altitudes[i + 1]) {
                        lengthOfPlateau++;
                        heightOfPlateau = altitudes[i];
                        startIndexOfPalteau = i - (lengthOfPlateau - 1);
                        System.out.println("Index: " + startIndexOfPalteau + " Height: " + heightOfPlateau + " Length: " + lengthOfPlateau);
                        lengthOfPlateau = 0;
                        heightOfPlateau = 0;
                        onPlateau = false;
                    }
                } else {
                    if ((altitudes[i - 1] < altitudes[i]) && (altitudes[i] == altitudes[i + 1])) {
                        lengthOfPlateau++;
                        onPlateau = true;
                    }
                }
            }
        }
    }
}