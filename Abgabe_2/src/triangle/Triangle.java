package triangle;

public class Triangle {
    public static void main(String[] args) {
        double a = 5.0;
        double b = 5.0;
        double c = 7.071;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        boolean rightTriangle = Math.abs(Math.pow(c, 2) - (Math.pow(a, 2) + Math.pow(b, 2))) < 0.1;

        if (rightTriangle) {
            System.out.println("Das Dreieck ist rechtwinklig.");
        } else {
            System.out.println("Das Dreieck ist nicht rechtwinklig.");
        }

    }
}
