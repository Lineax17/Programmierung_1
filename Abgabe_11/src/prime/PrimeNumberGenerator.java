package prime;

public class PrimeNumberGenerator {
    boolean numberIsPrime(long number) throws IllegalPrimeNumberArgumentException{
        boolean isPrime = true;
        //Fangen der Exception
        if (number < 1) {
            throw new IllegalPrimeNumberArgumentException("number needs to be at least 1. Argument was: " + number);
        }

        if (number < 2) {
            isPrime = false;
        } else {
            long limit = (long) Math.sqrt(number);
            for (int i = 2; i <= limit; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return isPrime;
    }

    long findNextPrimeNumber(long startNumber) throws IllegalPrimeNumberArgumentException {
        long number = startNumber;
        while (true) {
            if (numberIsPrime(number)) {
                break;
            } else {
                number++;
            }
        }
        return number;
    }

    void printPrimeNumbers(long startNumber, int numbers) throws IllegalPrimeNumberArgumentException {
        try {
            long number = startNumber;
            int counter = 0;
            while (counter < numbers) {
                if (numberIsPrime(number)) {
                    System.out.println(number);
                    counter++;
                }
                number++;
            }
        } catch (IllegalPrimeNumberArgumentException e) {
            long number = 2;
            int counter = 0;
            while (counter < numbers) {
                if (numberIsPrime(number)) {
                    System.out.println(number);
                    counter++;
                }
                number++;
            }
        }
    }

    public static void main(String[] args) throws IllegalPrimeNumberArgumentException {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        long startNumber = 1_000_000_000_000L;
        int numbers = 100;
        primeNumberGenerator.printPrimeNumbers(startNumber, numbers);
    }
}