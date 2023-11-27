package commandlinetools;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        //Fehler abfangen und Start-Ausgabe
        if (args.length != 1 || (!args[0].equals("-char-by-char") && !args[0].equals("-line-by-line"))) {
            System.out.println("Es wurden unpassende Aufrufargumente übergeben.");
            System.exit(1);
        }
        if (args[0].equals("-char-by-char")) {
            System.out.println("reverse -char-by-char");
        } else if (args[0].equals("-line-by-line")) {
            System.out.println("reverse -line-by-line");
        }

        //Nutzereingabe
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputLines = new StringBuilder();

        while (scanner.hasNextLine()) {
            inputLines.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        //Umwandlung
        String input = inputLines.toString();
        String output = "";

        if (args[0].equals("-char-by-char")) {
            StringBuilder inputLinesReversed = new StringBuilder(inputLines).reverse();
            output = output + inputLinesReversed.toString();
        } else if (args[0].equals("-line-by-line")) {
            String[] splitLine = inputLines.toString().split("\\R");
            for (int i = splitLine.length - 1; i >= 0; i--) {
                if (i == 0){
                    output = output + splitLine[i];
                }else {
                    output = output + splitLine[i] + "\n";
                }
            }
        }

        //Ausgabe
        System.out.println("Eingegebener Text:\n" + input.strip());
        System.out.println("Geänderter Text:\n" + output.strip());

    }
}
