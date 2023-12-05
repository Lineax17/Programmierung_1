package encryption;

public class OneTimePadTest {

    public static void main(String[] args) {
        if (args.length == 0) {
            new OneTimePadTest().printTests();
        } else if (args[0].equals("encrypt")) {
            new OneTimePad().encryptionInteractive();
        } else if (args[0].equals("decrypt")) {
            new OneTimePad().decryptionInteractive();
        }
    }

    public void printTests() {
        OneTimePad oneTimePad = new OneTimePad();
        String message = "Großer Baum um 18 Uhr!";
        byte[] messageBytes = message.getBytes();
        byte[] key = oneTimePad.createKey(messageBytes.length);
        byte[] encryptedMessage = oneTimePad.encryptMessage(messageBytes, key);
        byte[] decryptedMessage = oneTimePad.decryptMessage(encryptedMessage, key);
        String messageAsBinaryString = oneTimePad.toBinaryString(messageBytes);
        String keyAsBinaryString = oneTimePad.toBinaryString(key);
        String encryptedMessageAsBinaryString = oneTimePad.toBinaryString(encryptedMessage);
        System.out.println("1) Nachricht:           " + message);
        System.out.println("2) Nachricht binär:     " + messageAsBinaryString);
        System.out.println("3) Schlüssel binär:     " + keyAsBinaryString);
        System.out.println("4) Verschlüsselt binär: " + encryptedMessageAsBinaryString);
        System.out.println("5) Entschlüsselt:       " + new String(decryptedMessage));
    }
}
