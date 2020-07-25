package chapter10;

import java.time.LocalDateTime;

public class BizClock {
    private static BizClock DEFAULT = new BizClock();
    private static BizClock instance = DEFAULT;

    public static void reset() {
        instance = DEFAULT;
    }

    public static LocalDateTime now() {
        return instance.timeNow();
    }

    public void setInstance(BizClock bizClock) {
        BizClock.instance = bizClock;
    }

    public LocalDateTime timeNow() {
        return LocalDateTime.now();
    }
}
