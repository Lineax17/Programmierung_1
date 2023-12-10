package ledpanel.application;

import ledpanel.controller.API;
import ledpanel.controller.Path;
import ledpanel.controller.StringImage;

public class UserApplication {

    public static void main(String[] args) {
        UserApplication userApplication = new UserApplication();
        userApplication.lightShow();
    }

    private final API api;

    private UserApplication() {
        api = new API();
    }

    private void lightShow() {
        for (int i = 0; i < 100; i++) {

            api.directHardwareAccess().matrix0[0] = 1;
            api.directHardwareAccess().matrix4[7] = -128;
            api.waitFor(250);

            api.testLEDPanel();
            api.waitFor(250);

            api.showLEDs(new int[]{0, 39, 280, 319}, 100);
            api.waitFor(250);

            api.showBlinkingLEDs(new int[]{99, 101, 219, 221}, 100, 100, 2);
            api.waitFor(250);

            Path path1 = new Path(0, 39, 319, 280);
            api.showRunningDot(path1, 10, 1);
            api.waitFor(250);

            Path path2 = new Path(319, 280, 0, 39);
            api.showRunningDots(new Path[]{path1, path2}, 10, 1);
            api.waitFor(250);

            api.showString(new StringImage("Hallo").toString(), 500);
            api.waitFor(250);

            api.showMovingString(new StringImage("Herzlich Willkommen!").movingStrings(), 20, 1);
            api.waitFor(250);
        }
    }
}
