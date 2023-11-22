package methods;

public class Methods {
    static boolean even(int x) {
        return x % 2 == 0;
    }

    static double pythagoras(int x, int y) {
        double hypotenuse = Math.round(Math.sqrt((double) Math.pow(x, 2) + (double) Math.pow(y, 2)) * 100.0) / 100.0;
        return hypotenuse;
    }

    static int minimum(int x, int y, int z) {
        int minimum = Math.min(x, y);
        minimum = Math.min(minimum, z);
        return minimum;
    }

    static void printInfo() {
        System.out.println("--- Abgabe 5 ---");
    }

    static void printVariable(String name, int value) {
        System.out.println("int " + name + ": " + value);
    }

    static void printBoolean(String name, boolean x) {
        System.out.println(name + ": " + x);
    }

    static void printRoundedDouble(String name, double x) {
        System.out.println(name + ": " + x);
    }

    static void printInt(String name, int x) {
        System.out.println(name + ": " + x);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 20;


        printInfo();
        printVariable("a", a);
        printVariable("b", b);
        printVariable("c", c);
        printBoolean("even(a)", even(a));
        printRoundedDouble("pythagoras(a, b)", pythagoras(a, b));
        printInt("minimum(a, b, c)", minimum(a, b, c));
        printBoolean("Minimum von a, b und c ist ungerade", !even(minimum(a, b, c)));
        printInfo();
    }
}
