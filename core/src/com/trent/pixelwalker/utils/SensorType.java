package com.trent.pixelwalker.utils;

/**
 * Created by Sinthu on 4/28/2017.
 */

public enum SensorType {
    STEP_DETECTOR(1),
    STEP_COUNTER(1),
    ACCELEROMETER(3),
    NONE(0);

    public int args = 0;
    SensorType(int args) {
        this.args = args;
    }
}
