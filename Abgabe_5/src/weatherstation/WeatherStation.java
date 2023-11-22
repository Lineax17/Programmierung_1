package weatherstation;

public class WeatherStation {
    public static void main(String[] args) {
        // @formatter:off
        int[][] dailyMeanTemperatures = {
                { -3, 2, 6, 3, -1, 0, 4, 9, 9, 13, 5, 7, 11, 8, 10, 7, 4, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 4, 4, 3, 3 },
                { 2, 1, 0, -1, -1, 0, -2, -2, 0, 2, 0, -1, 1, 6, 1, 1, 1, 2, 2, 7, 5, 3, 4, 5, 5, 5, 5, 4 },
                { 8, 9, 8, 5, 4, 4, 5, 7, 8, 9, 8, 6, 5, 4, 4, 6, 9, 10, 10, 8, 8, 7, 9, 9, 8, 6, 8, 8, 11, 11, 12 },
                { 7, 6, 6, 6, 5, 5, 6, 8, 12, 15, 14, 15, 14, 15, 17, 19, 13, 10, 12, 13, 14, 14, 12, 14, 14, 16, 15, 9, 10, 13 },
                { 10, 12, 16, 19, 18, 16, 15, 16, 17, 17, 19, 22, 20, 18, 10, 14, 16, 17, 15, 11, 12, 13, 15, 16, 16, 13, 12, 15, 18, 16, 17 },
                { 18, 21, 23, 21, 25, 24, 23, 16, 16, 17, 21, 21, 21, 21, 18, 17, 17, 16, 16, 14, 16, 18, 15, 16, 18, 20, 21, 21, 22, 24 },
                { 26, 28, 29, 29, 30, 26, 27, 22, 20, 19, 24, 23, 22, 24, 24, 26, 29, 25, 24, 26, 27, 25, 22, 24, 21, 17, 19, 19, 16, 17, 17 },
                { 18, 21, 24, 21, 22, 27, 29, 27, 23, 22, 24, 25, 25, 21, 19, 16, 17, 16, 17, 18, 19, 20, 18, 17, 18, 19, 24, 25, 23, 26, 26 },
                { 22, 17, 17, 16, 14, 13, 13, 15, 16, 15, 15, 19, 18, 16, 15, 17, 16, 16, 14, 14, 14, 15, 12, 14, 13, 15, 14, 12, 14, 12 },
                { 10, 11, 16, 14, 15, 18, 16, 12, 12, 12, 12, 9, 8, 7, 5, 7, 6, 8, 8, 6, 7, 10, 12, 12, 15, 8, 8, 10, 12, 8, 9 },
                { 7, 7, 6, 10, 12, 16, 18, 16, 17, 13, 9, 8, 11, 11, 14, 15, 14, 15, 15, 12, 4, 3, 2, 0, 4, 4, -1, 3, 8, 10 },
                { 11, 8, 2, 9, 7, 11, 10, 7, 8, 1, 9, 9, 6, 3, 8, 12, 13, 12, 8, 10, 11, 12, 12, 11, 12, 11, 9, 4, 7, 4, 7 } };
        // @formatter:on

        //Anzahl der Tage
        int daysOfYear = 0;

        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                daysOfYear++;
            }
        }

        System.out.println("Die Anzahl der Tage im gegebenen Jahr ist: " + daysOfYear);

        //Jahresdurchschnittstemperatur
        double sumOfTemp = 0.0;
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                sumOfTemp = sumOfTemp + dailyMeanTemperatures[month][day];
            }
        }

        double averageYearTemp = Math.round(sumOfTemp / daysOfYear * 10) / 10.0;
        System.out.println("Jahresdurchschnittstemperatur: " + averageYearTemp + " Grad");

        //Monatsdurchschnittstemperaturen
        System.out.println("Monatsdurchschnittstemperaturen: ");
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            int daysOfMonth = 0;
            double sumOfMonth = 0;
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                daysOfMonth++;
                sumOfMonth = sumOfMonth + dailyMeanTemperatures[month][day];
            }
            double averageMonthTemp = Math.round(sumOfMonth / daysOfMonth * 10) / 10.0;

            System.out.println("* Monat " + (month + 1) + ": " + averageMonthTemp + " Grad");
        }

        //Wärmster Tag
        double warmestDayTemperatur = 0.0;
        int monthOfWarmestDay = 0;
        int dayOfWarmestDay = 0;
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                if (dailyMeanTemperatures[month][day] > warmestDayTemperatur) {
                    warmestDayTemperatur = dailyMeanTemperatures[month][day];
                    monthOfWarmestDay = month + 1;
                    dayOfWarmestDay = day + 1;
                }
            }
        }
        System.out.println("Wärmster Tag am " + dayOfWarmestDay + "." + monthOfWarmestDay + ".2015 mit " + (int) warmestDayTemperatur + " Grad.");

        //Übertragen in eindimensionales Array
        double[] temperatures = new double[daysOfYear];
        int counter = 0;
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                temperatures[counter] = dailyMeanTemperatures[month][day];
                counter++;
            }
        }

        //Hundertster Tag
        System.out.println("Temperaturen an jedem hundertsten Tag:");
        System.out.print("* ");
        for (int day = 99; day < temperatures.length; day = day + 100) {
            System.out.print("Tag " + (day + 1) + ": " + Math.round(temperatures[day]) + " Grad");
            if (day < temperatures.length - 100) {
                System.out.print(", ");
            }
        }

        //Sortiertes Array
        double[] sorted = new double[daysOfYear];
        for (int dayInSorted = 0; dayInSorted < sorted.length; dayInSorted++) {
            double warmestDay = -300;
            int replace = 0;
            for (int dayInTemperatures = 0; dayInTemperatures < temperatures.length; dayInTemperatures++) {
                if (temperatures[dayInTemperatures] >= warmestDay) {
                    warmestDay = temperatures[dayInTemperatures];
                    replace = dayInTemperatures;
                }
            }
            sorted[dayInSorted] = warmestDay;
            temperatures[replace] = -100.0;
        }

        //Ausgabe der ersten 5 Werte
        System.out.println();
        System.out.println("Die fünf wärmsten Tage: ");
        System.out.print("* ");
        for (int i = 0; i <= 4; i++) {
            System.out.print((int) sorted[i] + " Grad");
            if (i < 4) {
                System.out.print(", ");
            }
        }
    }
}
