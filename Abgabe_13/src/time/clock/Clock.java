package time.clock;

import time.clockanimation.gameview.Animations;

public class Clock {
    Animations animations;
    Clockwork clockwork;

    Clock() {
        animations = new Animations();
        clockwork = new Clockwork(new Time(13,10,15));
    }

    void runClock() {
        while (true) {
            clockwork.retrieveCurrentTime();
            animations.showClock(clockwork.retrieveCurrentTime().asFormattedString(), 30, 60, 90);
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.runClock();
    }
}
