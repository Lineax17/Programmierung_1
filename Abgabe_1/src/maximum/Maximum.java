package maximum;

public class Maximum {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        int z = -20;


        //(1)
        int maximum = 0;

        if (x <= y) {
            if (y <= z) {
                maximum = z;
            } else if (y >= z) {
                maximum = y;
            }
        } else if (x >= y) {
            if (x <= z) {
                maximum = z;
            } else if (x >= z) {
                maximum = x;
            }
        }


        //(2)
        int counter = 0;
        if (x < 0) {
            counter++;
        }
        if (y < 0) {
            counter++;
        }
        if (z < 0) {
            counter++;
        }



        //Ausgabe
        System.out.println("x ist " + x);
        System.out.println("y ist " + y);
        System.out.println("z ist " + z);

        System.out.println("(1) Das Maximum ist " + maximum);
        System.out.println("(2) Die Anzahl der negativen Zahlen ist " + counter);
    }
}
