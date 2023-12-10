package ledpanel.controller;

/**
 * Erzeugt ein StringImage auf dem LED-Panel. Jeder Buchstabe benötigt 8 * 8 LEDs auf dem Panel. Ein Wort mit 5
 * Buchstaben füllt das Panel.
 */
public class StringImage {

    private final String[] charsAs8Times8Strings;
    private final String string;
    private String stringImage;
    private final int linesOfCharImage;

    /**
     * Ein StringImage wird aus dem übergebenen String erzeugt.
     * <br><br>
     * Beispiele führt der Aufruf von
     * <pre>{@code new StringImage("A").toString()}</pre>
     * zum String <pre>"""
     *         \s
     *   ####  \s
     *  #    # \s
     *  #    # \s
     *  ###### \s
     *  #    # \s
     *  #    # \s
     *         \s"""</pre>
     * <br>
     *
     * @param string String, aus dem ein Bild erzeugt werden soll.
     */
    public StringImage(String string) {
        this.string = string;
        linesOfCharImage = 8;
        charsAs8Times8Strings = charsAs8Times8Strings();
        if (!string.isEmpty()) {
            createStringImage();
        }
    }

    @Override
    public String toString() {
        return stringImage;
    }

    /**
     * Diese Methode gibt ein Array von Strings zurück, dass für eine Animation benutzt werden kann, wenn man sie
     * hintereinander anzeigt. Der String erscheint am rechten Rand des Panels und scrollt zum linken Rand durch, bis er
     * ganz verschwunden ist.
     *
     * @return Das Array mit der Animation.
     */
    public String[] movingStrings() {
        return null;
    }

    private void createStringImage() {
        String[][] charImageLines = new String[string.length()][linesOfCharImage];
        for (int charIndex = 0; charIndex < string.length(); charIndex++) {
            charImageLines[charIndex] = charAs8Times8String(string.charAt(charIndex)).split("\\R");
        }
        StringBuilder stringImageBuilder = new StringBuilder();
        for (int line = 0; line < linesOfCharImage; line++) {
            for (int charIndex = 0; charIndex < string.length(); charIndex++) {
                stringImageBuilder.append(charImageLines[charIndex][line]);
            }
            stringImageBuilder.append("\n");
        }
        stringImage = stringImageBuilder.toString();
    }

    private String charAs8Times8String(char c) {
        int difference = '!';
        int index = c - difference;
        if (c == ' ') {
            return charsAs8Times8Strings[92];
        } else if (index < 0 || index >= charsAs8Times8Strings.length - 1) {
            return charsAs8Times8Strings['?'];
        } else {
            return charsAs8Times8Strings[index];
        }
    }

    private String[] charsAs8Times8Strings() {
        String[] charsAsStringImages = new String[93];
        charsAsStringImages[0] = """
                      \s
                #     \s
                #     \s
                #     \s
                #     \s
                      \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[1] = """
                      \s
                ####  \s
                #  #  \s
                      \s
                      \s
                      \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[2] = """
                      \s
                 #  # \s
                ######\s
                 #  # \s
                 #  # \s
                ######\s
                 #  # \s
                      \s""".indent(1);
        charsAsStringImages[3] = """
                      \s
                 #### \s
                # #   \s
                  #   \s
                 ###  \s
                  # # \s
                ####  \s
                      \s""".indent(1);
        charsAsStringImages[4] = """
                      \s
                ##  # \s
                ##  # \s
                   #  \s
                  #   \s
                 #  ##\s
                 #  ##\s
                      \s""".indent(1);
        charsAsStringImages[5] = """
                      \s
                 ##   \s
                #   # \s
                   #  \s
                 ##  #\s
                #   ##\s
                 ##  #\s
                      \s""".indent(1);
        charsAsStringImages[6] = """
                      \s
                #     \s
                #     \s
                #     \s
                      \s
                      \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[7] = """
                      \s
                 #    \s
                #     \s
                #     \s
                #     \s
                #     \s
                 #    \s
                      \s""".indent(1);
        charsAsStringImages[8] = """
                      \s
                #     \s
                 #    \s
                 #    \s
                 #    \s
                 #    \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[9] = """
                      \s
                      \s
                ####  \s
                ####  \s
                ####  \s
                ####  \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[10] = """
                      \s
                      \s
                  #   \s
                  #   \s
                ##### \s
                  #   \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[11] = """
                      \s
                      \s
                      \s
                      \s
                      \s
                 #    \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[12] = """
                      \s
                      \s
                      \s
                ####  \s
                ####  \s
                      \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[13] = """
                      \s
                      \s
                      \s
                      \s
                      \s
                      \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[14] = """
                      \s
                   #  \s
                   #  \s
                  #   \s
                 #    \s
                #     \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[15] = """
                      \s
                 #### \s
                #    #\s
                #    #\s
                #    #\s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[16] = """
                      \s
                  #   \s
                 ##   \s
                # #   \s
                  #   \s
                  #   \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[17] = """
                      \s
                 #### \s
                #    #\s
                    # \s
                   #  \s
                 #    \s
                ######\s
                      \s""".indent(1);
        charsAsStringImages[18] = """
                      \s
                ##### \s
                     #\s
                    # \s
                 #### \s
                     #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[19] = """
                      \s
                    # \s
                   ## \s
                  # # \s
                 #  # \s
                ######\s
                    # \s
                      \s""".indent(1);
        charsAsStringImages[20] = """
                      \s
                ######\s
                #     \s
                #     \s
                ##### \s
                     #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[21] = """
                      \s
                 #### \s
                #     \s
                #     \s
                ##### \s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[22] = """
                      \s
                ######\s
                     #\s
                     #\s
                    # \s
                  #   \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[23] = """
                      \s
                 #### \s
                #    #\s
                 #  # \s
                 #### \s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[24] = """
                      \s
                 #### \s
                #    #\s
                 #   #\s
                  ####\s
                     #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[25] = """
                      \s
                ##    \s
                ##    \s
                      \s
                      \s
                ##    \s
                ##    \s
                      \s""".indent(1);
        charsAsStringImages[26] = """
                      \s
                ##    \s
                ##    \s
                      \s
                      \s
                ##    \s
                 #    \s
                      \s""".indent(1);
        charsAsStringImages[27] = """
                      \s
                  #   \s
                 #    \s
                #     \s
                #     \s
                 #    \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[28] = """
                      \s
                      \s
                ####  \s
                      \s
                      \s
                ####  \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[29] = """
                      \s
                #     \s
                 #    \s
                  #   \s
                  #   \s
                 #    \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[30] = """
                      \s
                 ###  \s
                #   # \s
                    # \s
                  ##  \s
                      \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[31] = """
                      \s
                 #### \s
                #    #\s
                #    #\s
                # ####\s
                #     \s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[32] = """
                      \s
                 #### \s
                #    #\s
                #    #\s
                ######\s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[33] = """
                      \s
                ##### \s
                #    #\s
                #   # \s
                ##### \s
                #    #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[34] = """
                      \s
                 #### \s
                #    #\s
                #     \s
                #     \s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[35] = """
                      \s
                ##### \s
                #   # \s
                #    #\s
                #    #\s
                #   # \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[36] = """
                      \s
                ######\s
                #     \s
                #     \s
                ##### \s
                #     \s
                ######\s
                      \s""".indent(1);
        charsAsStringImages[37] = """
                      \s
                ######\s
                #     \s
                #     \s
                ##### \s
                #     \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[38] = """
                      \s
                 #### \s
                #     \s
                #     \s
                ##### \s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[39] = """
                      \s
                #    #\s
                #    #\s
                #    #\s
                ######\s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[40] = """
                      \s
                ##### \s
                  #   \s
                  #   \s
                  #   \s
                  #   \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[41] = """
                      \s
                    ##\s
                     #\s
                     #\s
                #    #\s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[42] = """
                      \s
                #    #\s
                #   # \s
                #  #  \s
                ####  \s
                #   # \s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[43] = """
                      \s
                #     \s
                #     \s
                #     \s
                #     \s
                #     \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[44] = """
                      \s
                #   # \s
                ## ## \s
                # # # \s
                #   # \s
                #   # \s
                #   # \s
                      \s""".indent(1);
        charsAsStringImages[45] = """
                      \s
                #   # \s
                ##  # \s
                # # # \s
                # # # \s
                #  ## \s
                #   # \s
                      \s""".indent(1);
        charsAsStringImages[46] = """
                      \s
                 #### \s
                #    #\s
                #    #\s
                #    #\s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[47] = """
                      \s
                ##### \s
                #    #\s
                #   # \s
                ##### \s
                #     \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[48] = """
                      \s
                 ###  \s
                #   # \s
                #   # \s
                #  ## \s
                #   # \s
                 ##  #\s
                      \s""".indent(1);
        charsAsStringImages[49] = """
                      \s
                ##### \s
                #    #\s
                #   # \s
                ##### \s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[50] = """
                      \s
                 #####\s
                #     \s
                 #    \s
                 #### \s
                     #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[51] = """
                      \s
                ######\s
                  #   \s
                  #   \s
                  #   \s
                  #   \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[52] = """
                      \s
                #    #\s
                #    #\s
                #    #\s
                #    #\s
                ##  ##\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[53] = """
                      \s
                #   # \s
                #   # \s
                #   # \s
                #   # \s
                 ###  \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[54] = """
                      \s
                #   # \s
                #   # \s
                #   # \s
                # # # \s
                ## ## \s
                #   # \s
                      \s""".indent(1);
        charsAsStringImages[55] = """
                      \s
                #    #\s
                #    #\s
                 #  # \s
                  ##  \s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[56] = """
                      \s
                #   # \s
                #   # \s
                 # #  \s
                 ###  \s
                  #   \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[57] = """
                      \s
                ######\s
                    # \s
                   #  \s
                  #   \s
                 #    \s
                ######\s
                      \s""".indent(1);
        charsAsStringImages[58] = """
                      \s
                ##    \s
                #     \s
                #     \s
                #     \s
                #     \s
                ##    \s
                      \s""".indent(1);
        charsAsStringImages[59] = """
                      \s
                #     \s
                #     \s
                 #    \s
                  #   \s
                   #  \s
                   #  \s
                      \s""".indent(1);
        charsAsStringImages[60] = """
                      \s
                ##    \s
                 #    \s
                 #    \s
                 #    \s
                 #    \s
                ##    \s
                      \s""".indent(1);
        charsAsStringImages[61] = """
                      \s
                 #    \s
                # #   \s
                # #   \s
                      \s
                      \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[62] = """
                      \s
                      \s
                      \s
                      \s
                      \s
                      \s
                ######\s
                      \s""".indent(1);
        charsAsStringImages[63] = """
                      \s
                #     \s
                 #    \s
                 #    \s
                      \s
                      \s
                      \s
                      \s""".indent(1);
        charsAsStringImages[64] = """
                      \s
                      \s
                 #####\s
                 #   #\s
                #    #\s
                #    #\s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[65] = """
                      \s
                #     \s
                #     \s
                ##### \s
                #    #\s
                #    #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[66] = """
                      \s
                      \s
                 #####\s
                 #    \s
                #     \s
                #     \s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[67] = """
                      \s
                     #\s
                     #\s
                 #####\s
                #    #\s
                #    #\s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[68] = """
                      \s
                      \s
                 #####\s
                #    #\s
                # ### \s
                #     \s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[69] = """
                      \s
                  ####\s
                 #    \s
                 #    \s
                ##### \s
                 #    \s
                 #    \s
                      \s""".indent(1);
        charsAsStringImages[70] = """
                      \s
                 #####\s
                #    #\s
                 #   #\s
                 #####\s
                     #\s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[71] = """
                      \s
                #     \s
                #     \s
                ##### \s
                #    #\s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[72] = """
                      \s
                  #   \s
                      \s
                 ##   \s
                  #   \s
                  #   \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[73] = """
                      \s
                  #   \s
                      \s
                  #   \s
                  #   \s
                  #   \s
                ##    \s
                      \s""".indent(1);
        charsAsStringImages[74] = """
                      \s
                #     \s
                #   ##\s
                #  #  \s
                # #   \s
                ####  \s
                #   ##\s
                      \s""".indent(1);
        charsAsStringImages[75] = """
                     \s
                ##   \s
                 #   \s
                 #   \s
                 #   \s
                 #   \s
                ###  \s
                     \s""".indent(2);
        charsAsStringImages[76] = """
                      \s
                      \s
                ##### \s
                # # # \s
                # # # \s
                # # # \s
                # # # \s
                      \s""".indent(1);
        charsAsStringImages[77] = """
                      \s
                      \s
                ##### \s
                #   ##\s
                #    #\s
                #    #\s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[78] = """
                      \s
                      \s
                 #### \s
                #    #\s
                #    #\s
                #    #\s
                 #### \s
                      \s""".indent(1);
        charsAsStringImages[79] = """
                      \s
                      \s
                ##### \s
                #    #\s
                #   # \s
                ##### \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[80] = """
                      \s
                      \s
                 #####\s
                #    #\s
                #    #\s
                 #####\s
                     #\s
                      \s""".indent(1);
        charsAsStringImages[81] = """
                      \s
                      \s
                ##### \s
                #    #\s
                #     \s
                #     \s
                #     \s
                      \s""".indent(1);
        charsAsStringImages[82] = """
                      \s
                 #### \s
                #     \s
                 #    \s
                 #### \s
                     #\s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[83] = """
                      \s
                 #    \s
                ##### \s
                 #    \s
                 #    \s
                 #    \s
                  ####\s
                      \s""".indent(1);
        charsAsStringImages[84] = """
                      \s
                      \s
                #    #\s
                #    #\s
                #    #\s
                #    #\s
                 #####\s
                      \s""".indent(1);
        charsAsStringImages[85] = """
                      \s
                      \s
                #   # \s
                #   # \s
                #   # \s
                 ###  \s
                  #   \s
                      \s""".indent(1);
        charsAsStringImages[86] = """
                      \s
                      \s
                # # # \s
                # # # \s
                # # # \s
                # # # \s
                 ###  \s
                      \s""".indent(1);
        charsAsStringImages[87] = """
                      \s
                      \s
                #    #\s
                 #  # \s
                  ##  \s
                 #  # \s
                #    #\s
                      \s""".indent(1);
        charsAsStringImages[88] = """
                      \s
                      \s
                #    #\s
                 #### \s
                     #\s
                    # \s
                ##### \s
                      \s""".indent(1);
        charsAsStringImages[89] = """
                      \s
                      \s
                ######\s
                    # \s
                   #  \s
                  #   \s
                ######\s
                      \s""".indent(1);
        charsAsStringImages[90] = """
                      \s
                  ##  \s
                 #    \s
                #     \s
                 #    \s
                 #    \s
                  ##  \s
                      \s""".indent(1);
        charsAsStringImages[91] = """
                     \s
                #    \s
                #    \s
                #    \s
                #    \s
                #    \s
                #    \s
                     \s""".indent(1);
        charsAsStringImages[92] = """
                \s
                \s
                \s
                \s
                \s
                \s
                \s
                \s""".indent(7);
        return charsAsStringImages;
    }
}