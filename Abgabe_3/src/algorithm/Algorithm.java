package algorithm;

public class Algorithm {
    public static void main(String[] args) {
        int a = 205;
        int b = 10;
        int result = 0;

        System.out.println("int a: " + a);
        System.out.println("int b: " + b);

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        if (b == 0) {
            result = a;
        } else {
            result = b;
        }

        System.out.println("Ergebnis: " + result);
    }
}
