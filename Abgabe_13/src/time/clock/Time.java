package time.clock;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    protected Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        if (hours > 23 || minutes > 59 || seconds > 59) {
            throw new IllegalArgumentException("Numbers are too high: " + "hours = " + hours + " minutes = " + minutes + " seconds = " + seconds);
        }
    }

    private static int millisToHours(long milliseconds) {
        long hours = milliseconds / (1000 * 60 * 60);
        return (int) hours;
    }

    private static int millisToMinutes(long milliseconds) {
        long hoursRemainder = milliseconds % (1000 * 60 * 60);
        long minutes = hoursRemainder / (1000 * 60);
        return (int) minutes;
    }

    private static int millisToSeconds(long milliseconds) {
        long hoursRemainder = milliseconds % (1000 * 60 * 60);
        long minutesRemainder = hoursRemainder % (1000 * 60);
        long seconds = minutesRemainder / 1000;
        return (int) seconds;
    }


    public Time(long milliseconds) {
        this(millisToHours(milliseconds), millisToMinutes(milliseconds), millisToSeconds(milliseconds));
    }

    String asFormattedString() {
        String hoursString = "" + hours;
        String minutesString = "" + minutes;
        String secondsString = "" + seconds;

        if (hours < 10) {
            hoursString = "0" + hours;
        }
        if (minutes < 10) {
            minutesString = "0" + minutes;
        }
        if (seconds < 10) {
            secondsString = "0" + seconds;
        }
        return hoursString + ":" + minutesString + ":" + secondsString;
    }

    long asMilliseconds(int hours, int minutes, int seconds) {
        return hours * 60 * 60 * 1000 + minutes * 60 * 1000 + seconds * 1000;
    }
}
