package meanvalues;

public class MeanValues {
    static double mean(int x, int y, int z) {
        return Math.round((((double) x + (double) y + (double) z) / 3.0) * 10.0) / 10.0;
    }

    static int median(int x, int y, int z) {
        int median = 0;
        if ((x <= y && y <= z) || (z <= y && y <= x)) {
            median = y;
        } else if ((y <= x && x <= z) || (z <= x && x <= y)) {
            median = x;
        } else if ((x <= z && z <= y) || (y <= z && z <= x)) {
            median = z;
        }
        return median;
    }

    static int modal(int x, int y, int z) {
        int modal = 0;
        if (x == y) {
            modal = y;
        } else if (y == z) {
            modal = z;
        } else {
            modal = x;
        }
        return modal;
    }


    public static void main(String[] args) {
        int a = 8;
        int b = -700;
        int c = 2;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("Mean: " + mean(a, b, c));
        System.out.println("Median: " + median(a, b, c));
        System.out.println("Modal: " + modal(a, b, c));
    }
}
