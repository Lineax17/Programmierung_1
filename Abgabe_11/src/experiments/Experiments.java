package experiments;

import java.util.Random;

public class Experiments {
    private static final int REPETITIONS = 1_000_000;
    private Binomial binomial;
    private int seed;
    private Random random;

    Experiments() {
        binomial = new Binomial();
        random = new Random();
    }

    private long evaluate(boolean thirdPowerShort) {
        long startTime = System.nanoTime();
        random.setSeed(seed);
        for (int i = 1; i <= REPETITIONS; i++) {

            double a = random.nextInt(10);
            double b = random.nextInt(10);

            if (thirdPowerShort) {
                binomial.thirdPowerShort(a, b);
            } else {
                binomial.thirdPowerLong(a, b);

            }
        }
        long endTime = System.nanoTime();
        long timeToCalculate = endTime - startTime;
        return timeToCalculate;
    }

    private void printResult(String theorem, long duration) {
        System.out.println(theorem);
        System.out.println("Wiederholungen: " + REPETITIONS);
        System.out.println("Zeit benötigt: " + duration + " ns");
        System.out.println("Durchschnitt pro Berechnung: " + duration / REPETITIONS + " ns");
        System.out.println();
    }

    private void execute() {
        //Volllaufen der Caches
        evaluate(true);
        evaluate(false);

        //Short
        long runningTime = evaluate(true);
        printResult("(a + b)³", runningTime);

        //Long
        runningTime = evaluate(false);
        printResult("a³ + 3a²b + 3ab² + b³", runningTime);

    }

    /*
    void testRandom() {
        random.setSeed(seed);
        for (int i = 1; i <= 10; i++) {
            double a = random.nextInt(10);
            double b = random.nextInt(10);
            System.out.println(a + " : " + b);
        }
        System.out.println();
        random.setSeed(seed);
        for (int i = 1; i <= 10; i++) {
            double a = random.nextInt(10);
            double b = random.nextInt(10);
            System.out.println(a + " : " + b);
        }
    }
    */


    public static void main(String[] args) {
        Experiments experiments = new Experiments();
        experiments.execute();
        //experiments.testRandom();
    }
}
