package logic;

public class Logic {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        boolean c = true;

        boolean term1 = a && b && (c || !a);
        boolean term2 = !a && (!b || c);
        boolean term3 = !a || !b || c;

        System.out.println("Eingabe");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        System.out.println();

        System.out.println("Ergebnis");
        System.out.println("term1: " + term1);
        System.out.println("term2: " + term2);
        System.out.println("term3: " + term3);

    }
}
