package calculator;

public class Calculator {
    public static void main(String[] args) {
        double x = 5.1;
        double y = 3.1;

        String operator = "-";

        double result = 0.0;

        if (operator.equals("+")) {
            result = x + y;
        } else if (operator.equals("-")) {
            result = x - y;
        } else if (operator.equals("*")) {
            result = x * y;
        } else if (operator.equals("/")) {
            result = x / y;
        } else {
            System.out.println("Falsche Rechenvorschrift: " + operator);
            System.exit(1);
        }

        System.out.println(x + " " + operator + " " + y + " = " + result);
    }
}
