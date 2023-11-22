package quiz;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        long startTimeInMs = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int input;
        int random = 1 + (int) (Math.random() * 1000);
        int trys = 0;


        while (true) {
            System.out.print("Bitte eine Zahl eingeben: ");
            input = scanner.nextInt();
            trys++;

            if (input < random) {
                System.out.println("Ihre Zahl ist zu niedrig!");
            } else if (input > random) {
                System.out.println("Ihre Zahl ist zu hoch!");
            } else {
                long endTimeInMs = System.currentTimeMillis();
                System.out.println();
                System.out.println("Treffer!");

                long timeToComplete = (endTimeInMs - startTimeInMs)/1000;
                System.out.println("Sie haben " + trys + " Versuche benötigt.");
                System.out.println("Sie haben " + timeToComplete + " Sekunden benötigt.");

                break;
            }

        }
        scanner.close();



    }
}
