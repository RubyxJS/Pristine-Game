package com.muby.util;

public class Time {
    public static double timeStart = System.nanoTime();

    public static float getTime() {
        return (float) ((System.nanoTime() - timeStart) * 1E-9);
    }
}
