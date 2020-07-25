package chapter10;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBizClock extends BizClock {
    private LocalDateTime now;

    public TestBizClock() {
        setInstance(this);
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    @Override
    public LocalDateTime timeNow() {
        return now != null ? now : super.now();
    }
}
