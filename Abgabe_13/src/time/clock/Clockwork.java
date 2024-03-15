package time.clock;

public class Clockwork {
    Time startTime;

    Clockwork(Time startTime) {
        this.startTime = startTime;
    }

    Time retrieveCurrentTime() {
        return startTime;
    }
}
