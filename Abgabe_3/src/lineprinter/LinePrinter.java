package lineprinter;

public class LinePrinter {
    public static void main(String[] args) {
        String word = "Hallo!";
        int numberOfChars = 100;
        String line = "";
        int numberOfPrintedChars = 0;
        int lines = 0;
        int words = 0;

        while (numberOfPrintedChars <= numberOfChars) {
            line = line + word;
            numberOfPrintedChars = numberOfPrintedChars + line.length();
            lines = lines + 1;
            words = words + lines;

            System.out.println(line);
        }

        System.out.println();
        System.out.println("Limit: " + numberOfChars + " Zeichen.");
        System.out.println("Es wurden " + numberOfPrintedChars + " Zeichen ausgegeben.");
        System.out.println("Es wurden " + lines + " Zeilen ausgegeben.");
        System.out.println("Es wurden " + words + " Wörter ausgegeben.");
    }
}

