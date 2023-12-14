package prime;

public class PrimeNumberGenerator {
    boolean numberIsPrime(long number) {
        boolean isPrime = true;
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

    long findNextPrimeNumber(long startNumber){
        while (true) {
            if (numberIsPrime(startNumber)) {
                break;
            } else {
                startNumber++;
            }
        }
        return startNumber;
    }

    public static void main(String[] args) {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        System.out.println(primeNumberGenerator.numberIsPrime(1));
        System.out.println(primeNumberGenerator.findNextPrimeNumber(15));
    }
}


