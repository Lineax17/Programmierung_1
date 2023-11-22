package palindrom;

public class Palindrom {
    static boolean palindrom(String word) {
        boolean isPalindrom = false;
        String wordInLowerCase = word.toLowerCase();
        for (int i = 0; i < wordInLowerCase.length(); i++) {

            char char1 = wordInLowerCase.charAt(i);
            char char2 = wordInLowerCase.charAt(wordInLowerCase.length() - 1 - i);

            if (char1 == char2) {
                isPalindrom = true;
            } else {
                return false;
            }
        }
        return isPalindrom;
    }

    public static void main(String[] args) {
        String word = "Reliefpfeiler";
        System.out.println(palindrom(word));
    }
}
