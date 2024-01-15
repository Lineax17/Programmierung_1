package time.clockanimation.gameview;

import java.awt.*;

/**
 * Diese Klasse ermöglicht es kleine Animationen eines bayerischen Kartenspiels anzuzeigen.
 */
public class Animations {
    private final GameView gameView;
    private int lastDegreeSeconds;
    private long lastTimeTicked;
    private boolean firstTick;

    /**
     * Erzeugt eine Instanz dieser Klasse um Animationen anzeigen zu können.
     */
    public Animations() {
        this.gameView = new GameView();
        gameView.setWindowTitle("Uhr");
        lastDegreeSeconds = -1;
        lastTimeTicked = System.currentTimeMillis();
        firstTick = true;
    }

    /**
     * Zeigt eine Uhr mit Digital- und Analog-Anzeige an.
     *
     * @param time          Die digitale Zeit, die angezeigt werden soll im Format: "hh:mm:ss".
     * @param degreeHours   Der Winkel des Stundenzeigers: 0° bis 360°, 0° entspricht 12 Uhr.
     * @param degreeMinutes Der Winkel des Minutenzeigers: 0° bis 360°, 0° entspricht 12 Uhr.
     * @param degreeSeconds Der Winkel des Sekundenzeigers: 0° bis 360°, 0° entspricht 12 Uhr.
     */
    public void showClock(String time, int degreeHours, int degreeMinutes, int degreeSeconds) {
        long timePassed = System.currentTimeMillis() - lastTimeTicked;
        if (lastDegreeSeconds != degreeSeconds && timePassed > 50) {
            if (firstTick) {
                firstTick = false;
            } else {
                gameView.playSound("tick.wav", false);
            }
            lastDegreeSeconds = degreeSeconds;
            lastTimeTicked = System.currentTimeMillis();
        }
        int x = GameView.WIDTH / 2;
        int y = GameView.HEIGHT / 2;
        int size = GameView.HEIGHT - 50;
        paintCase(x, y, size);
        paintDigitalClock(time, x, y, size);
        //gameView.addTextToCanvas("ALARM", x - 15 * 2.5, y - 200, 15, Color.YELLOW.darker(), 0);
        paintPointers(degreeHours, degreeMinutes, degreeSeconds, x, y, size);
        gameView.printCanvas();
    }

    private void paintDigitalClock(String time, int x, int y, int size) {
        int fontSize = size / 20;
        gameView.addRectangleToCanvas(x - 4 * fontSize - 2, y + 3 * fontSize - 2, fontSize * 8, fontSize, 2, false, Color.WHITE);
        gameView.addTextToCanvas(time, x - 4 * fontSize, y + 3 * fontSize, fontSize, Color.YELLOW, 0);
    }

    private void paintCase(int x, int y, int size) {
        double endY = y - size / 2d;
        for (int i = 0; i < 360; i += 30) {
            gameView.addLineToCanvas(x, y, getRotatedX(x, y, x, endY, i), getRotatedY(x, y, x, endY, i), 5, Color.WHITE);
        }
        gameView.addOvalToCanvas(x, y, size - 50, size - 50, 5, true, Color.BLACK);
        gameView.addOvalToCanvas(x - 2, y - 2, size, size, 5, false, Color.WHITE);
    }

    private void paintPointers(int degreeHours, int degreeMinutes, int degreeSeconds, int x, int y, int size) {
        int innerSize = 30;
        double endYHours = y - size / 2d + 120;
        double endYMinutes = y - size / 2d + 60;
        double endYSeconds = y - size / 2d + 30;
        double endYAlarm = y - size / 2d + 170;
        printPointer(x, y, endYHours, degreeHours, 15, Color.WHITE);
        printPointer(x, y, endYMinutes, degreeMinutes, 10, Color.WHITE);
        // printPointer(x, y, endYAlarm, 30, 5, Color.YELLOW.darker());
        gameView.addOvalToCanvas(x, y, innerSize, innerSize, 0, true, Color.WHITE);
        gameView.addOvalToCanvas(x, y, innerSize, innerSize, 1, false, Color.BLACK);
        printPointer(x, y, endYSeconds, degreeSeconds, 3, Color.RED);
        gameView.addOvalToCanvas(x, y, 10, 10, 0, true, Color.RED);
        gameView.addOvalToCanvas(x, y, 10, 10, 1, false, Color.BLACK);
    }

    private void printPointer(int x, int y, double endY, int degree, int weight, Color color) {
        gameView.addLineToCanvas(x, y, getRotatedX(x, y, x, endY, degree), getRotatedY(x, y, x, endY, degree), weight, color);
    }

    private double getRotatedX(double startX, double startY, double endX, double endY, int degree) {
        return Math.cos(Math.toRadians(degree)) * (endX - startX) - Math.sin(Math.toRadians(degree)) * (endY - startY) + startX;
    }

    private double getRotatedY(double startX, double startY, double endX, double endY, int degree) {
        return Math.sin(Math.toRadians(degree)) * (endX - startX) + Math.cos(Math.toRadians(degree)) * (endY - startY) + startY;
    }
}
