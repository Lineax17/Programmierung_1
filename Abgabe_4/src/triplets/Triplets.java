package triplets;

public class Triplets {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;

        boolean tripletOfOnes = false;
        boolean tripletOfTwos = false;
        boolean tripletOfThrees = false;

        int sumOfX = 0;
        int sumOfY = 0;
        int sumOfZ = 0;

        int counter = 0;
        while (true) {
            x = 1 + (int) (Math.random() * 6);
            y = 1 + (int) (Math.random() * 6);
            z = 1 + (int) (Math.random() * 6);

            sumOfX = sumOfX + x;
            sumOfY = sumOfY + y;
            sumOfZ = sumOfZ + z;


            System.out.println("Wurf " + counter + ": " + x + ", " + y + ", " + z);
            counter++;

            //Delay
            try {
                Thread.sleep(5);
            } catch (InterruptedException ignored) {
            }


            //Triplets
            if (x == 1 && y == 1 && z == 1) {
                System.out.println("Trippel!");
                tripletOfOnes = true;
            } else if (x == 2 && y == 2 && z == 2) {
                System.out.println("Trippel!");
                tripletOfTwos = true;
            } else if (x == 3 && y == 3 && z == 3) {
                System.out.println("Trippel!");
                tripletOfThrees = true;
            } else if (x == y && y == z) {
                System.out.println("Trippel!");
            }


            //Schleifen-End-Bedingung
            if (tripletOfThrees && tripletOfOnes && tripletOfTwos) {
                System.out.println();
                System.out.println("Einser-, Zweier- und Dreier - Trippel waren dabei!");
                break;
            }

        }

        //Mittelwerte berechnung
        double medianX = (double) sumOfX / (double) counter;
        double medianY = (double) sumOfY / (double) counter;
        double medianZ = (double) sumOfZ / (double) counter;

        System.out.println("Mittelwert Würfel 1: " + medianX);
        System.out.println("Mittelwert Würfel 2: " + medianY);
        System.out.println("Mittelwert Würfel 3: " + medianZ);


    }
}
