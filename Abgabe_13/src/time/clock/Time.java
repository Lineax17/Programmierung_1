package time.clock;

public class Time {
    int hours;
    int minutes;
    int seconds;

    Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        if (hours > 23 || minutes > 59 || seconds > 59 ) {
            throw new IllegalArgumentException("Numbers are too high: " + "hours = " + hours + " minutes = " + minutes + " seconds = " + seconds);
        }
    }

    Time(long milliseconds) {

    }
}
