package seasons;

public class Seasons {
    public static void main(String[] args) {
        int month = 9;
        String season = null;

        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Frühling";
                break;
            case 6:
            case 7:
            case 8:
                season = "Sommer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Herbst";
                break;
            default:
                System.out.println("Falscher Monat!");
                System.exit(1);
       }

        System.out.println("Der " + month + ". Monat ist im " + season + ".");
    }
}
