package name;

public class Name {
    public static void main(String[] args) {
        String name = "Philipp Hartmann";
        String separator = " + ";
        String line = name + separator + name + separator + name + "\n";
        String output = line + line + line;

        System.out.println(output);
    }
}
