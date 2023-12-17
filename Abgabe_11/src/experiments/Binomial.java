package experiments;

public class Binomial {
    double thirdPowerShort(double a, double b) {
        double result = Math.pow((a + b), 3);
        return result;
    }

    double thirdPowerLong(double a, double b) {
        double result = Math.pow(a, 3) + (3 * Math.pow(a, 2) * b) + (3 * a * Math.pow(b, 2)) + Math.pow(b, 3);
        return result;
    }
}

