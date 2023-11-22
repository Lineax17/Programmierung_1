package firstarray;

public class FirstArray {
    public static void main(String[] args) {
        int size = 100;
        String[] strings = new String[size];

        strings[0] = "Anfang";
        strings[strings.length - 1] = "Ende";

        for (int i = 1; i < size-1; i++) {
            strings[i] = "Mitte";
        }

        for (String string /* Name der Zählvariable */ : strings) {
            System.out.println(string);
        }
    }


}
