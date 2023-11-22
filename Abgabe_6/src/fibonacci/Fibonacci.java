package fibonacci;
import java.util.Arrays;

public class Fibonacci {
    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int fibo;
            fibo = fibonacci(n - 1) + fibonacci(n - 2);
            return fibo;
        }
    }

    static int fibonacciLoop(int n) {
        int[] fibo = new int[n];
        for (int i = 0; i < fibo.length; i++) {
            if (i == 0 || i == 1) {
                fibo[i] = 1;
            } else {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
        }
        return fibo[n - 1];
    }

    static int[] fibonacciSequence(int n, int m) {
        int[] fiboSequence = new int[(m - n) + 1];
        for (int i = 0; i <= (m - n); i++) {
            fiboSequence[i] = fibonacci(n + i);
        }
        return fiboSequence;
    }


    public static void main(String[] args) {
        int n = 21;
        int m = 25;
        System.out.println("fibonacci(" + n + ") = " + fibonacci(n));
        System.out.println("fibonacciLoop(" + n + ") = " + fibonacciLoop(n));
        System.out.println("fibonacciSequence(" + n + ", " + m + ") = " + Arrays.toString(fibonacciSequence(n, m)));
    }
}
