package temperatures;

public class Temperatures {
    public static void main(String[] args) {
        double[] minimumTemperatures = new double[30];
        double[] maximumTemperatures = new double[30];

        for (int i = 0; i < minimumTemperatures.length; i++) {
            minimumTemperatures[i] = Math.random() * 10;
        }

        for (int i = 0; i < maximumTemperatures.length; i++) {
            maximumTemperatures[i] = 5 + Math.random() * 15;
        }


        System.out.println("Unsortiert:");
        for (int i = 0; i < minimumTemperatures.length; i++) {
            System.out.println("Tag " + (i + 1) + ": Minimum = " + minimumTemperatures[i] + ", Maximum = " + maximumTemperatures[i]);
        }


        for (int i = 0; i < minimumTemperatures.length; i++) {
            if (minimumTemperatures[i] > maximumTemperatures[i]) {
                double temp = minimumTemperatures[i];
                minimumTemperatures[i] = maximumTemperatures[i];
                maximumTemperatures[i] = temp;
            }
        }

        System.out.println();
        System.out.println("Sortiert:");
        for (int i = 0; i < minimumTemperatures.length; i++) {
            System.out.println("Tag " + (i + 1) + ": Minimum = " + minimumTemperatures[i] + ", Maximum = " + maximumTemperatures[i]);
        }
    }
}
