package gascalculator;

public class GasCalculator {
    public static void main(String[] args) {
        float km = 992.7F;
        float gasInLiters = 87.1F;
        float averageConsumptionIn100Km = (gasInLiters / km) * 100;

        System.out.println("---Benzinrechner---\n"
            + "Gefahrene Kilometer: "
            + km
            + "\nVerbrauchtes Benzin: "
            + gasInLiters
            + "\nIhr Auto hat einen Verbrauch von "
            + averageConsumptionIn100Km
            + " Litern Benzin pro 100 Kilometer.");
    }
}
