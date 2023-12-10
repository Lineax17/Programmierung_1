package exponentialgrowth;

import java.math.BigInteger;

public class ExponentialGrowth {
    private void printInt() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " (int): " + (int) Math.pow(10, i));
        }
    }

    private void printLong() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " (long): " + (long) Math.pow(10, i));
        }
    }

    private void printBigInteger() {
        for (int i = 1; i <= 25; i++) {
            BigInteger bigInt = BigInteger.valueOf(10);
            bigInt = bigInt.pow(i);
            System.out.println(i + " (BigInteger): " + bigInt);
        }
    }

    public static void main(String[] args) {
        ExponentialGrowth exponentialGrowth = new ExponentialGrowth();
        exponentialGrowth.printInt();
        System.out.println();
        exponentialGrowth.printLong();
        System.out.println();
        exponentialGrowth.printBigInteger();
    }
}
