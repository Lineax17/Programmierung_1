package encryption;

import java.security.SecureRandom;
import java.util.Scanner;

class OneTimePad {

    /**
     * Erzeugt einen Schlüssel in der angegebenen Länge.
     *
     * @param lengthInBytes Die länge des Schlüssels in Bytes.
     * @return Der Schlüssel.
     */
    byte[] createKey(int lengthInBytes) {
        byte[] key = new byte[lengthInBytes];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);
        return key;
    }

    /**
     * Diese Methode wandelt das übergebene Byte-Array in einen Binärstring um. Nach je 8 Bits wird ein Leerzeichen
     * eingefügt.
     *
     * @param bytes Das umzuwandelnde Byte-Array.
     * @return Der Binärstring.
     */
    String toBinaryString(byte[] bytes) {
        // Teil 1) Bitte implementieren: Verwenden Sie zur Umwandlung die Bitmasken aus dem Skript.
        int[] mask = {128, 64, 32, 16, 8, 4, 2, 1};
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bytes[i] & mask[j]) >>> (7 - j) == 1) {
                    binary.append("1");
                } else {
                    binary.append("0");
                }
            }
            binary.append(" ");
        }
        return binary.toString();
    }

    /**
     * Diese Methode verschlüsselt die übergebene Nachricht mit dem Schlüssel. Dabei wird jedes Byte der Nachricht durch
     * den Exklusiv-Oder-Operator mit dem entsprechenden Byte des Schlüssels verknüpft.
     *
     * @param message Die zu verschlüsselnde Nachricht.
     * @param key     Der Schlüssel.
     * @return Die verschlüsselte Nachricht als Byte-Array.
     */
    byte[] encryptMessage(byte[] message, byte[] key) {
        // Teil 1) Bitte implementieren.
        byte[] encrypted = new byte[message.length];

        for (int i = 0; i < message.length; i++) {
            int messageByte = Byte.toUnsignedInt(message[i]);
            int keyByte = Byte.toUnsignedInt(key[i]);

            encrypted[i] = (byte) (messageByte ^ keyByte);

        }
        return encrypted;
    }

    /**
     * Diese Methode entschlüsselt die übergebene verschlüsselte Nachricht mit dem Schlüssel. Dabei wird jedes Byte der
     * Nachricht durch den Exklusiv-Oder-Operator mit dem entsprechenden Byte des Schlüssels verknüpft.
     *
     * @param encryptedMessage Die verschlüsselte Nachricht.
     * @param key              Der Schlüssel.
     * @return Die entschlüsselte Nachricht als Byte-Array.
     */
    byte[] decryptMessage(byte[] encryptedMessage, byte[] key) {
        // Teil 1) Bitte implementieren.
        byte[] decrypted = new byte[encryptedMessage.length];

        for (int i = 0; i < encryptedMessage.length; i++) {
            int messageByte = Byte.toUnsignedInt(encryptedMessage[i]);
            int keyByte = Byte.toUnsignedInt(key[i]);

            decrypted[i] = (byte) (messageByte ^ keyByte);

        }
        return decrypted;
    }

    /**
     * Diese Methode wandelt den übergebenen Binärstring (mit Leerzeichen zwischen je 8 Bits) in ein Byte-Array um.
     *
     * @param binaryString Der Binärstring.
     * @return Das Byte-Array.
     */
    private byte[] toByteArray(String binaryString) {
        // Teil 2) Bitte implementieren: Verwenden Sie zur Umwandlung eines einzelnen Bytes die folgende Anweisung
        //   byte b = (byte) Integer.parseInt(byteString, 2);
        String[] strings = binaryString.split(" ");
        byte[] bytes = new byte[strings.length];

        for (int i = 0; i < strings.length; i++) {
            bytes[i] = (byte) Integer.parseInt(strings[i], 2);
        }

        return bytes;
    }

    /**
     * Diese Methode fragt interaktiv nach einer zu verschlüsselnden Nachricht. Es wird ein Schlüssel erzeugt und die
     * Nachricht wird mit dem Schlüssel verschlüsselt.
     * <p>
     * Schlüssel und verschlüsselte Nachricht werden als Binärstring ausgegeben.
     */
    void encryptionInteractive() {
        System.out.println("***Verschlüsseln einer Nachricht***");
        // Teil 2) Bitte implementieren.
        // Hier ein paar Bausteine:
        //   System.out.print("Bitte den zu verschlüsselnden Text eingeben: ");
        //   System.out.println("Der Schlüssel:\n" + keyAsBinaryString);
        //   System.out.println("Die verschlüsselte Nachricht:\n" + encryptedMessageAsBinaryString);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte den zu verschlüsselnden Text eingeben: ");

        String messageString = scanner.nextLine();

        byte[] messageByteArray = messageString.getBytes();
        byte[] keyByteArray = createKey(messageString.length());

        String keyBinaryString = toBinaryString(keyByteArray);
        System.out.println("Der Schlüssel:\n" + keyBinaryString);

        byte[] encryptedByteArray = encryptMessage(messageByteArray, keyByteArray);

        String encryptedBinaryString = toBinaryString(encryptedByteArray);
        System.out.println("Die verschlüsselte Nachricht:\n" + encryptedBinaryString);
    }

    /**
     * Diese Methode fragt interaktiv nach einer verschlüsselten Nachricht und nach einem Schlüssel. Die Nachricht wird
     * mit dem Schlüssel entschlüsselt.
     * <p>
     * Die entschlüsselte Nachricht wird im Klartext ausgegeben.
     */
    void decryptionInteractive() {
        System.out.println("***Entschlüsseln einer Nachricht***");
        // Teil 2) Bitte implementieren.
        // Hier ein paar Bausteine:
        //   System.out.print("Bitte den zu entschlüsselnden Binärstring eingeben: ");
        //   System.out.print("Bitte den Schlüssel als Binärstring eingeben: ");
        //   System.out.println("Die entschlüsselte Nachricht:\n" + decryptedMessage);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte den zu entschlüsselnden Binärstring eingeben: ");
        String encryptedBinary = scanner.nextLine();
        byte[] encryptedByteArray = toByteArray(encryptedBinary);

        System.out.print("Bitte den Schlüssel als Binärstring eingeben: ");
        String keyBinary = scanner.nextLine();
        byte[] keyByteArray = toByteArray(keyBinary);

        byte[] decryptedByteArray = decryptMessage(encryptedByteArray, keyByteArray);
        String decryptedString = new String(decryptedByteArray);
        System.out.println("Die entschlüsselte Nachricht:\n" + decryptedString);
    }
}
