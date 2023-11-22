package multiplicationtable;

public class MultiplicationTable {
    public static void main(String[] args) {
        int startValue = 1;
        int endValue = 9;

        System.out.println("Von: " + startValue + " * " + startValue + " = " + startValue * startValue);
        System.out.println("Bis: " + endValue + " * " + endValue + " = " + endValue * endValue);
        System.out.println();


        for (int i = startValue; i <= endValue; i++) {
            for (int j = startValue; j <= endValue; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}
