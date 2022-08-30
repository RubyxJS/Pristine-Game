package com.muby.mvc;

import java.time.Duration;

public class Clock {
    private long past;

    public Clock() {
        this.past = System.nanoTime();
    }

    public Duration tick() {
        long now = System.nanoTime();
        Duration duration = Duration.ofNanos(now - past);
        past = now;
        return duration;
    }
}
